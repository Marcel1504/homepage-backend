package me.marcelberger.homepage.backend.service.ai.api;

import lombok.extern.slf4j.Slf4j;
import me.marcelberger.homepage.backend.data.ai.HpAIRequestData;
import me.marcelberger.homepage.backend.data.ai.HpAIResponseData;
import me.marcelberger.homepage.backend.exception.HpException;
import me.marcelberger.homepage.backend.service.stacktrace.HpStacktraceService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class HpAIApiServiceImpl implements HpAIApiService {

    private final RestTemplate restTemplate;

    private final HpStacktraceService stacktraceService;

    @Value("${homepage.assistant.api.path}")
    private String apiPath;

    public HpAIApiServiceImpl(
            HpStacktraceService stacktraceService,
            @Qualifier("assistantApi") RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.stacktraceService = stacktraceService;
    }

    @Override
    public HpAIResponseData sendRequest(HpAIRequestData request) {
        try {
            return restTemplate.postForObject(apiPath, request, HpAIResponseData.class);
        } catch (Exception e) {
            log.debug("Can not call AI-API: {}", stacktraceService.convertToSingleLine(e));
            throw new HpException(HpException.Code.HP1002);
        }
    }
}
