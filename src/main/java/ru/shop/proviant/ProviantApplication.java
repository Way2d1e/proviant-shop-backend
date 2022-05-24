package ru.shop.proviant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.shop.proviant.config.propetries.MailProperties;


@SpringBootApplication
@EnableConfigurationProperties(MailProperties.class)
public class ProviantApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviantApplication.class, args);
    }
}