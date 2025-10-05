package me.marcelberger.homepage.backend.service.ai.runner;


import me.marcelberger.homepage.backend.data.ai.HpAIMessageData;

import java.util.List;

public interface HpAIRunnerService {
    List<HpAIMessageData> run(final List<HpAIMessageData> messages);
}
