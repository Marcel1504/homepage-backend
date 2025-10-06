package me.marcelberger.homepage.backend.data.chat;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class HpChatResponseData {
    private Long chatId;
    private List<HpChatResponseMessageData> messages;
}
