package me.marcelberger.homepage.backend.facade.chat;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import me.marcelberger.homepage.backend.data.chat.HpChatRequestData;
import me.marcelberger.homepage.backend.data.chat.HpChatResponseData;

public interface HpChatFacade {
    HpChatResponseData createChatResponse(@NotNull @Valid HpChatRequestData chatRequest);
}
