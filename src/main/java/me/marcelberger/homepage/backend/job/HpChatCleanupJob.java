package me.marcelberger.homepage.backend.job;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.marcelberger.homepage.backend.entity.HpChatEntity;
import me.marcelberger.homepage.backend.service.chat.HpChatService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class HpChatCleanupJob {

    private final HpChatService chatService;

    @Scheduled(initialDelay = 10000, fixedDelay = 60000)
    public void run() {
        LocalDateTime threshold = LocalDateTime.now(ZoneOffset.UTC).minusHours(24);
        List<HpChatEntity> oldChats = chatService.getAllByLastActivityTimeUtcBefore(threshold);
        int size = oldChats.size();
        oldChats.forEach(chatService::delete);
        if (size > 0) {
            log.info("Deleted {} chat(s) that were older than 24 hours", size);
        }
    }
}
