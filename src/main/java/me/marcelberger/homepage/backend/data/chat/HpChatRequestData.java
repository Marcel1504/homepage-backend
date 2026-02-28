package me.marcelberger.homepage.backend.data.chat;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import me.marcelberger.homepage.backend.annotation.HpChatConsent;

@Data
@Builder
public class HpChatRequestData {
    private Long chatId;

    @NotNull
    @HpChatConsent
    private String consent;

    @NotNull
    private String message;
}
