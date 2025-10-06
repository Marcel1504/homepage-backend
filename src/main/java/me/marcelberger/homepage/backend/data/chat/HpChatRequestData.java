package me.marcelberger.homepage.backend.data.chat;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HpChatRequestData {
    private Long chatId;
    @NotNull
    private String message;
}
