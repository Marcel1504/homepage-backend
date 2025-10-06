package me.marcelberger.homepage.backend.service.ai.property;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.marcelberger.homepage.backend.data.ai.HpAIMessageData;
import me.marcelberger.homepage.backend.data.ai.HpAIToolData;
import me.marcelberger.homepage.backend.enumeration.ai.HpAIRoleEnum;
import me.marcelberger.homepage.backend.exception.HpException;
import me.marcelberger.homepage.backend.service.stacktrace.HpStacktraceService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class HpAIPropertyServiceImpl implements HpAIPropertyService {

    private final ObjectMapper objectMapper;

    private final HpStacktraceService stacktraceService;

    @Value("${homepage.assistant.tools.available}")
    private Set<String> toolsAvailable;

    @Value("${homepage.assistant.tools.filePattern}")
    private String toolsFilePattern;

    @Value("${homepage.assistant.message.system}")
    private String messageSystem;

    @Override
    public List<HpAIToolData> getAvailableTools() {
        List<HpAIToolData> functions = new ArrayList<>();
        for (String name : toolsAvailable) {
            try {
                Resource fileResource = new ClassPathResource(toolsFilePattern.replace("{name}", name));
                String fileContent = new String(fileResource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
                HpAIToolData tool = objectMapper.readValue(fileContent, HpAIToolData.class);
                functions.add(tool);
            } catch (IOException e) {
                log.debug("Can not load available AI-tools: {}", stacktraceService.convertToSingleLine(e));
                throw new HpException(HpException.Code.HP1001);
            }
        }
        return functions;
    }

    @Override
    public HpAIMessageData generateSystemMessage() {
        String message = messageSystem.replace(
                "{date}",
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        return HpAIMessageData.builder()
                .role(HpAIRoleEnum.SYSTEM)
                .content(message)
                .build();
    }

    @Override
    public HpAIMessageData generateUserMessage(String message) {
        return HpAIMessageData.builder()
                .role(HpAIRoleEnum.USER)
                .content(message)
                .build();
    }
}
