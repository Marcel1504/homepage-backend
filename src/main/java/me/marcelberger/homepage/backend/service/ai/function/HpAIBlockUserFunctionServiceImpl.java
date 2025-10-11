package me.marcelberger.homepage.backend.service.ai.function;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import me.marcelberger.homepage.backend.data.ai.function.HpAIFunctionGetContentData;
import me.marcelberger.homepage.backend.enumeration.ai.HpAIFunctionEnum;
import me.marcelberger.homepage.backend.exception.HpException;
import me.marcelberger.homepage.backend.service.stacktrace.HpStacktraceService;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class HpAIBlockUserFunctionServiceImpl extends HpAIFunctionService<HpAIFunctionGetContentData> {

    public HpAIBlockUserFunctionServiceImpl(
            ObjectMapper objectMapper,
            HpStacktraceService stacktraceService) {
        super(objectMapper, stacktraceService);
    }

    @Override
    public HpAIFunctionEnum getFunction() {
        return HpAIFunctionEnum.BLOCK_USER;
    }

    @Override
    protected Class<HpAIFunctionGetContentData> getFunctionCallDataClass() {
        return HpAIFunctionGetContentData.class;
    }

    @Override
    protected String executeByFunctionCallData(HpAIFunctionGetContentData data) {
        throw new HpException(HpException.Code.HP1003);
    }
}
