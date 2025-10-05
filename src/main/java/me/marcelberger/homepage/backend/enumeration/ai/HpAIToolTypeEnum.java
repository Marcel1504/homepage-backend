package me.marcelberger.homepage.backend.enumeration.ai;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HpAIToolTypeEnum {
    @JsonProperty("function")
    FUNCTION,
    @JsonEnumDefaultValue
    UNKNOWN;
}
