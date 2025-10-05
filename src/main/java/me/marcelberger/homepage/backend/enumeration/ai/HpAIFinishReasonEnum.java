package me.marcelberger.homepage.backend.enumeration.ai;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HpAIFinishReasonEnum {
    @JsonProperty("tool_calls")
    TOOL_CALLS,

    @JsonEnumDefaultValue
    @JsonProperty("stop")
    STOP;
}
