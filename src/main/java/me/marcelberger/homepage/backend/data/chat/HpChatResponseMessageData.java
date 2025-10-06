package me.marcelberger.homepage.backend.data.chat;

import lombok.Builder;
import lombok.Data;
import me.marcelberger.homepage.backend.enumeration.chat.HpChatResponseMessageTypeEnum;

@Data
@Builder
public class HpChatResponseMessageData {
    private String content;
    private HpChatResponseMessageTypeEnum type;
}
