package me.marcelberger.homepage.backend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class HpAssistantApiConfig {

    @Value("${homepage.assistant.api.host}")
    private String host;

    @Value("${homepage.assistant.api.key}")
    private String key;

    @Value("${homepage.assistant.api.timeoutSeconds}")
    private Integer timeoutSeconds;

    @Bean(name = "assistantApi")
    public RestTemplate assistantApiRestTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder
                .rootUri(host)
                .defaultHeader("Authorization", String.format("Bearer %s", key))
                .defaultHeader("Content-Type", "application/json")
                .connectTimeout(Duration.ofSeconds(timeoutSeconds))
                .readTimeout(Duration.ofSeconds(timeoutSeconds))
                .build();
    }
}
