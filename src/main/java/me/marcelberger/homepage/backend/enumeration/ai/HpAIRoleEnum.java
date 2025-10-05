package me.marcelberger.homepage.backend.enumeration.ai;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum HpAIRoleEnum {
    @JsonProperty("user")
    USER,
    @JsonEnumDefaultValue
    @JsonProperty("assistant")
    ASSISTANT,
    @JsonProperty("system")
    SYSTEM,
    @JsonProperty("function")
    FUNCTION;
}
