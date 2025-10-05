package me.marcelberger.homepage.backend.service.ai.function;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import me.marcelberger.homepage.backend.data.ai.function.HpAIFunctionGetContentData;
import me.marcelberger.homepage.backend.enumeration.ai.HpAIFunctionEnum;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
@Slf4j
public class HpAIGetContentFunctionServiceImpl extends HpAIFunctionService<HpAIFunctionGetContentData> {

    public HpAIGetContentFunctionServiceImpl(ObjectMapper objectMapper) {
        super(objectMapper);
    }

    @Override
    public HpAIFunctionEnum getFunction() {
        return HpAIFunctionEnum.GET_CONTENT;
    }

    @Override
    protected Class<HpAIFunctionGetContentData> getFunctionCallDataClass() {
        return HpAIFunctionGetContentData.class;
    }

    @Override
    protected Map<String, Object> executeByFunctionCallData(HpAIFunctionGetContentData data) {
        return Map.of(ERROR_KEY, "Not implemented yet");
    }
}
