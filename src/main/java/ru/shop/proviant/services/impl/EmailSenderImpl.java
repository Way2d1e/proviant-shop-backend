package ru.shop.proviant.services.impl;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import ru.shop.proviant.dto.OrderDto;
import ru.shop.proviant.services.EmailSenderService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;


@Service
public class EmailSenderImpl implements EmailSenderService {

    private JavaMailSender javaMailSender;

    private SpringTemplateEngine springTemplateEngine;

    @Override
    public void sendHtmlMessage(OrderDto orderDto) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
        helper.setTo(orderDto.getEmail());
        helper.setSubject("Заказ #" + orderDto.getId());
        Context context = new Context();
        context.setVariable("name", orderDto);
        String html = springTemplateEngine.process("letter.html", context);
        helper.setText(html, true);
        javaMailSender.send(message);
    }
}
