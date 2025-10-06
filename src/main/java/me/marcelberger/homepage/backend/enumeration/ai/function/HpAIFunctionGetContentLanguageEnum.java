package me.marcelberger.homepage.backend.enumeration.ai.function;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public enum HpAIFunctionGetContentLanguageEnum {
    @JsonProperty("de")
    DE,

    @JsonEnumDefaultValue
    @JsonProperty("en")
    EN
}
