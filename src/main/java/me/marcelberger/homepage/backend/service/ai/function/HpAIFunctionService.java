package me.marcelberger.homepage.backend.service.ai.function;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import me.marcelberger.homepage.backend.data.ai.HpAIToolCallFunctionData;
import me.marcelberger.homepage.backend.enumeration.ai.HpAIFunctionEnum;
import me.marcelberger.homepage.backend.exception.HpException;

import java.util.Map;

@RequiredArgsConstructor
public abstract class HpAIFunctionService<DATA> {

    public static final String ERROR_KEY = "error";
    public static final String FUNCTION_KEY = "function";

    private final ObjectMapper objectMapper;

    public String executeFunctionCall(HpAIToolCallFunctionData functionCall) {
        try {
            DATA data = objectMapper.readValue(functionCall.getArguments(), getFunctionCallDataClass());
            return objectMapper.writeValueAsString(executeByFunctionCallData(data));
        } catch (JacksonException e) {
            throw new HpException(HpException.Code.HP1001);
        }
    }

    public abstract HpAIFunctionEnum getFunction();

    protected abstract Class<DATA> getFunctionCallDataClass();

    protected abstract Map<String, Object> executeByFunctionCallData(DATA data);
}
