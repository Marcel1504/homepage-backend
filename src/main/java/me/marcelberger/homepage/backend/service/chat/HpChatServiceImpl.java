package me.marcelberger.homepage.backend.service.chat;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.marcelberger.homepage.backend.data.ai.HpAIMessageData;
import me.marcelberger.homepage.backend.data.chat.HpChatRequestData;
import me.marcelberger.homepage.backend.entity.HpChatEntity;
import me.marcelberger.homepage.backend.exception.HpException;
import me.marcelberger.homepage.backend.repository.HpChatRepository;
import me.marcelberger.homepage.backend.service.ai.property.HpAIPropertyService;
import me.marcelberger.homepage.backend.service.stacktrace.HpStacktraceService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class HpChatServiceImpl implements HpChatService {

    private final HpChatRepository chatRepository;

    private final HpAIPropertyService aiPropertyService;

    private final ObjectMapper objectMapper;

    private final HpStacktraceService stacktraceService;

    @Override
    public HpChatEntity getOrCreate(HpChatRequestData chatRequest) {
        HpChatEntity chat = getByIdOrNull(chatRequest.getChatId());
        if (chat == null) {
            try {
                HpAIMessageData systemMessage = aiPropertyService.generateSystemMessage();
                List<HpAIMessageData> messages = List.of(systemMessage);
                String content = objectMapper.writeValueAsString(messages);
                chat = HpChatEntity.builder()
                        .lastActivityTimeUtc(LocalDateTime.now(ZoneId.of("UTC")))
                        .content(content)
                        .build();
                chatRepository.save(chat);
            } catch (Exception e) {
                log.debug("Can not get or create chat: {}", stacktraceService.convertToSingleLine(e));
                throw new HpException(HpException.Code.HP1001);
            }
        }
        return chat;
    }

    @Override
    public HpChatEntity updateContent(HpChatEntity chat, List<HpAIMessageData> messages) {
        try {
            String content = objectMapper.writeValueAsString(messages);
            chat.setContent(content);
            chat.setLastActivityTimeUtc(LocalDateTime.now(ZoneId.of("UTC")));
            return chatRepository.save(chat);
        } catch (Exception e) {
            log.debug("Can not update chat content: {}", stacktraceService.convertToSingleLine(e));
            throw new HpException(HpException.Code.HP1001);
        }
    }

    @Override
    public HpChatEntity getByIdOrNull(Long id) {
        if (id != null) {
            return chatRepository.findById(id).orElse(null);
        }
        return null;
    }

    @Override
    public List<HpAIMessageData> getContent(HpChatEntity chat) {
        try {
            return objectMapper.readValue(chat.getContent(), new TypeReference<>() {
            });
        } catch (Exception e) {
            log.debug("Can not get chat content: {}", stacktraceService.convertToSingleLine(e));
            throw new HpException(HpException.Code.HP1001);
        }
    }

    @Override
    public void delete(HpChatEntity chat) {
        if (chat != null) {
            chatRepository.delete(chat);
        }
    }

    @Override
    public List<HpChatEntity> getAllByLastActivityTimeUtcBefore(LocalDateTime time) {
        return chatRepository.findByLastActivityTimeUtcBefore(time);
    }
}
