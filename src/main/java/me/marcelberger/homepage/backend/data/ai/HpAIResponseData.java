package me.marcelberger.homepage.backend.data.ai;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class HpAIResponseData {
    private String id;
    private String object;
    private Long created;
    private String model;
    private List<HpAIChoiceData> choices;
    private HpAIUsageData usage;
}
