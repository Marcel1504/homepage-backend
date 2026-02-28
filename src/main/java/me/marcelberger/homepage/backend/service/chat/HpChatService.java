package me.marcelberger.homepage.backend.service.chat;

import me.marcelberger.homepage.backend.data.ai.HpAIMessageData;
import me.marcelberger.homepage.backend.data.chat.HpChatRequestData;
import me.marcelberger.homepage.backend.entity.HpChatEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface HpChatService {

    HpChatEntity getOrCreate(HpChatRequestData chatRequest);

    HpChatEntity updateContent(HpChatEntity chat, List<HpAIMessageData> messages);

    HpChatEntity getByIdOrNull(Long id);

    List<HpAIMessageData> getContent(HpChatEntity chat);

    void delete(HpChatEntity chat);

    List<HpChatEntity> getAllByLastActivityTimeUtcBefore(LocalDateTime time);
}
