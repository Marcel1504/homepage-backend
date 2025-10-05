package me.marcelberger.homepage.backend.service.ai.api;

import me.marcelberger.homepage.backend.data.ai.HpAIRequestData;
import me.marcelberger.homepage.backend.data.ai.HpAIResponseData;

public interface HpAIApiService {
    HpAIResponseData sendRequest(HpAIRequestData request);
}

