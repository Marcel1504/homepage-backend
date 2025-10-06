package me.marcelberger.homepage.backend.service.ai.function;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.marcelberger.homepage.backend.data.ai.HpAIToolCallFunctionData;
import me.marcelberger.homepage.backend.enumeration.ai.HpAIFunctionEnum;
import me.marcelberger.homepage.backend.exception.HpException;
import me.marcelberger.homepage.backend.service.stacktrace.HpStacktraceService;

@RequiredArgsConstructor
@Slf4j
public abstract class HpAIFunctionService<DATA> {

    private final ObjectMapper objectMapper;

    protected final HpStacktraceService stacktraceService;

    public String executeFunctionCall(HpAIToolCallFunctionData functionCall) {
        try {
            DATA data = objectMapper.readValue(functionCall.getArguments(), getFunctionCallDataClass());
            return executeByFunctionCallData(data);
        } catch (JacksonException e) {
            log.debug(stacktraceService.convertToSingleLine(e));
            throw new HpException(HpException.Code.HP1001);
        }
    }

    public abstract HpAIFunctionEnum getFunction();

    protected abstract Class<DATA> getFunctionCallDataClass();

    protected abstract String executeByFunctionCallData(DATA data);
}
