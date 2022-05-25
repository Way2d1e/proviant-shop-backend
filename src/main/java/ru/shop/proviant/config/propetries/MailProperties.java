package ru.shop.proviant.config.propetries;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.mail")
@Getter
@Setter
public class MailProperties {

    private String templateName;

    private String sellerMail;

}
