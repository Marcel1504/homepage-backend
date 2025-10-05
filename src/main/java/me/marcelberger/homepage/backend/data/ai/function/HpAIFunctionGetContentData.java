package me.marcelberger.homepage.backend.data.ai.function;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.marcelberger.homepage.backend.enumeration.ai.function.HpAIFunctionGetContentEnum;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HpAIFunctionGetContentData {
    @JsonProperty("type")
    private HpAIFunctionGetContentEnum type;
}
