package me.marcelberger.homepage.backend.data.ai;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class HpAIRequestData {
    private String model;
    private List<HpAIMessageData> messages;
    private List<HpAIToolData> tools;
}
