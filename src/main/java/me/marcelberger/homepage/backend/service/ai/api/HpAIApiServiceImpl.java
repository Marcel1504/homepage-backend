package me.marcelberger.homepage.backend.service.ai.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.marcelberger.homepage.backend.data.ai.HpAIRequestData;
import me.marcelberger.homepage.backend.data.ai.HpAIResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HpAIApiServiceImpl implements HpAIApiService {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    @Qualifier("assistantApi")
    private RestTemplate restTemplate;

    @Value("${homepage.assistant.api.path}")
    private String apiPath;

    @Override
    public HpAIResponseData sendRequest(HpAIRequestData request) {
        return restTemplate.postForObject(apiPath, request, HpAIResponseData.class);
    }
}
