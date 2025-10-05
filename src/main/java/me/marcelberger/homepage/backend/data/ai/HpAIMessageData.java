package me.marcelberger.homepage.backend.data.ai;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import me.marcelberger.homepage.backend.enumeration.ai.HpAIFunctionEnum;
import me.marcelberger.homepage.backend.enumeration.ai.HpAIRoleEnum;

import java.util.List;

@Data
@Builder
public class HpAIMessageData {
    private HpAIRoleEnum role;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String content;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private HpAIFunctionEnum name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("tool_calls")
    private List<HpAIToolCallData> toolCalls;
}
