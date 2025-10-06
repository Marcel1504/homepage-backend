package me.marcelberger.homepage.backend.facade.chat;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.marcelberger.homepage.backend.data.ai.HpAIMessageData;
import me.marcelberger.homepage.backend.data.chat.HpChatRequestData;
import me.marcelberger.homepage.backend.data.chat.HpChatResponseData;
import me.marcelberger.homepage.backend.data.chat.HpChatResponseMessageData;
import me.marcelberger.homepage.backend.entity.HpChatEntity;
import me.marcelberger.homepage.backend.enumeration.chat.HpChatResponseMessageTypeEnum;
import me.marcelberger.homepage.backend.service.ai.property.HpAIPropertyService;
import me.marcelberger.homepage.backend.service.ai.runner.HpAIRunnerService;
import me.marcelberger.homepage.backend.service.chat.HpChatService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
@RequiredArgsConstructor
public class HpChatFacadeImpl implements HpChatFacade {

    private final HpChatService chatService;

    private final HpAIRunnerService aiRunnerService;

    private final HpAIPropertyService aiPropertyService;

    @Override
    @Transactional
    public HpChatResponseData createChatResponse(HpChatRequestData chatRequest) {
        HpChatEntity chat = chatService.getOrCreate(chatRequest);
        List<HpAIMessageData> messages = chatService.getContent(chat);
        messages.add(aiPropertyService.generateUserMessage(chatRequest.getMessage()));
        List<HpAIMessageData> newMessages = aiRunnerService.run(messages);
        int newMessagesCount = newMessages.size() - messages.size();
        chat = chatService.updateContent(chat, newMessages);
        List<HpChatResponseMessageData> responseMessages = mapChatResponseMessages(newMessages, newMessagesCount);
        return HpChatResponseData.builder()
                .chatId(chat.getId())
                .messages(responseMessages)
                .build();
    }

    private List<HpChatResponseMessageData> mapChatResponseMessages(
            List<HpAIMessageData> messages,
            int newMessagesCount) {
        int newMessageEndIndex = messages.size();
        int newMessageStartIndex = newMessageEndIndex - newMessagesCount;
        List<HpAIMessageData> newAiMessages = messages.subList(newMessageStartIndex, newMessageEndIndex);
        return newAiMessages.stream()
                .filter(this::isTextMessage)
                .map(this::buildTextResponse)
                .toList();
    }

    private boolean isTextMessage(HpAIMessageData message) {
        return message.getToolCalls() == null && message.getName() == null;
    }

    private HpChatResponseMessageData buildTextResponse(HpAIMessageData message) {
        return HpChatResponseMessageData.builder()
                .content(message.getContent())
                .type(HpChatResponseMessageTypeEnum.TEXT)
                .build();
    }
}
