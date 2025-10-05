package me.marcelberger.homepage.backend.data.ai;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import me.marcelberger.homepage.backend.enumeration.ai.HpAIFinishReasonEnum;

@Data
@Builder
public class HpAIChoiceData {
    private Long index;
    private HpAIMessageData message;

    @JsonProperty("finish_reason")
    private HpAIFinishReasonEnum finishReason;
}
