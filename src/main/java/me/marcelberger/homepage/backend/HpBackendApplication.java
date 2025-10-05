package me.marcelberger.homepage.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "me.marcelberger")
@EntityScan("me.marcelberger")
@EnableJpaRepositories("me.marcelberger")
public class HpBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(HpBackendApplication.class, args);
    }

}
