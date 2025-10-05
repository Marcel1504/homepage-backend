package me.marcelberger.homepage.backend.service.ai.property;

import me.marcelberger.homepage.backend.data.ai.HpAIMessageData;
import me.marcelberger.homepage.backend.data.ai.HpAIToolData;

import java.util.List;

public interface HpAIPropertyService {
    List<HpAIToolData> getAvailableTools();

    HpAIMessageData generateSystemMessage();
}
