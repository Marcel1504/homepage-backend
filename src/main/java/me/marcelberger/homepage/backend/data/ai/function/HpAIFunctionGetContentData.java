package me.marcelberger.homepage.backend.data.ai.function;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.marcelberger.homepage.backend.enumeration.ai.function.HpAIFunctionGetContentLanguageEnum;
import me.marcelberger.homepage.backend.enumeration.ai.function.HpAIFunctionGetContentTypeEnum;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HpAIFunctionGetContentData {
    @JsonProperty("lang")
    private HpAIFunctionGetContentLanguageEnum language;

    @JsonProperty("type")
    private HpAIFunctionGetContentTypeEnum type;
}
