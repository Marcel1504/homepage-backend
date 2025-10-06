package me.marcelberger.homepage.backend.service.ai.runner;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.marcelberger.homepage.backend.data.ai.*;
import me.marcelberger.homepage.backend.enumeration.ai.HpAIFinishReasonEnum;
import me.marcelberger.homepage.backend.enumeration.ai.HpAIRoleEnum;
import me.marcelberger.homepage.backend.exception.HpException;
import me.marcelberger.homepage.backend.service.ai.api.HpAIApiService;
import me.marcelberger.homepage.backend.service.ai.function.HpAIFunctionService;
import me.marcelberger.homepage.backend.service.ai.property.HpAIPropertyService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class HpAIRunnerServiceImpl implements HpAIRunnerService {

    private final HpAIPropertyService aiPropertyService;

    private final HpAIApiService aiApiService;

    private final List<HpAIFunctionService<?>> aiFunctionServices;

    @Value("${homepage.assistant.api.model}")
    private String model;

    @Value("${homepage.assistant.message.contextLimit}")
    private Integer contextLimit;

    /**
     * Runs an AI call with the specified messages
     *
     * @param messages The messages for the chat
     * @return The messages including newly generated messages
     */
    @Override
    public List<HpAIMessageData> run(final List<HpAIMessageData> messages) {
        // Create copy of message to preserve immutability
        List<HpAIMessageData> updatedMessages = new ArrayList<>(messages);

        // run AI API call with the input AI messages
        HpAIResponseData response = callAIAPI(updatedMessages);
        validateAIResponse(response);
        HpAIChoiceData firstChoice = response.getChoices().getFirst();
        updatedMessages.add(firstChoice.getMessage());
        if (HpAIFinishReasonEnum.TOOL_CALLS.equals(firstChoice.getFinishReason())) {
            // API call response requires a function call
            handleToolCall(updatedMessages, firstChoice.getMessage().getToolCalls().getFirst());
        }
        return updatedMessages;
    }

    private void handleToolCall(List<HpAIMessageData> inputMessages,
                                HpAIToolCallData toolCall) {
        // execute the tool call with function services
        HpAIMessageData functionResultMessage = HpAIMessageData.builder()
                .role(HpAIRoleEnum.FUNCTION)
                .name(toolCall.getFunction().getName())
                .content(executeFunction(toolCall.getFunction()))
                .build();
        inputMessages.add(functionResultMessage);

        // run AI API call to provide the result of the tool call
        HpAIResponseData response = callAIAPI(inputMessages);
        validateAIResponse(response);
        HpAIChoiceData firstChoice = response.getChoices().getFirst();
        inputMessages.add(firstChoice.getMessage());
    }

    private String executeFunction(HpAIToolCallFunctionData functionCall) {
        return aiFunctionServices.stream()
                .filter(service -> service.getFunction().equals(functionCall.getName()))
                .findFirst()
                .map(service -> service.executeFunctionCall(functionCall))
                .orElse(null);
    }

    private void validateAIResponse(HpAIResponseData response) {
        if (response == null || response.getChoices() == null || response.getChoices().isEmpty()) {
            log.debug("Invalid AI response: response or choices not provided");
            throw new HpException(HpException.Code.HP1001);
        }
    }

    private HpAIResponseData callAIAPI(List<HpAIMessageData> messages) {
        // reduce context messages (messages between the first and the latest message)
        List<HpAIMessageData> messagesToSend = new ArrayList<>();
        messagesToSend.add(messages.getFirst());
        int startIdx = Math.max(1, messages.size() - contextLimit);
        messagesToSend.addAll(messages.subList(startIdx, messages.size()));

        // call AI API
        HpAIRequestData chatRequest = HpAIRequestData.builder()
                .model(model)
                .messages(messagesToSend)
                .tools(aiPropertyService.getAvailableTools())
                .build();
        return aiApiService.sendRequest(chatRequest);
    }
}
