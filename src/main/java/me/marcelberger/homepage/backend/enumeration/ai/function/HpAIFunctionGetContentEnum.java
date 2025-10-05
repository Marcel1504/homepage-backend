package me.marcelberger.homepage.backend.enumeration.ai.function;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HpAIFunctionGetContentEnum {
    @JsonProperty("profile")
    PROFILE,

    @JsonProperty("projects")
    PROJECTS,

    @JsonProperty("jobs")
    JOBS,

    @JsonProperty("certifications")
    CERTIFICATIONS,

    @JsonProperty("education")
    EDUCATION,

    @JsonProperty("social_links")
    SOCIAL_LINKS,

    @JsonEnumDefaultValue
    UNKNOWN;
}
