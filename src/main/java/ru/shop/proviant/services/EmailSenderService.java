package ru.shop.proviant.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import ru.shop.proviant.dto.OrdersDto;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailSenderService {


    private final JavaMailSender emailSender;
    private final SpringTemplateEngine springTemplateEngine;

    public void sendHtmlMessage(OrdersDto ordersDto) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
        helper.setTo(ordersDto.getEmail_client());
        helper.setSubject("Order");
        String html = springTemplateEngine.process("Letter.html", new Context());
        helper.setText(html, true);
        emailSender.send(message);
    }
}
