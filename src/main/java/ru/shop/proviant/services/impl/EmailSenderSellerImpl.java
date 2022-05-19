package ru.shop.proviant.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import ru.shop.proviant.model.entity.Order;
import ru.shop.proviant.services.EmailSenderService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
public class EmailSenderSellerImpl implements EmailSenderService {

    private final JavaMailSender javaMailSender;

    private final SpringTemplateEngine springTemplateEngine;

    @Override
    public void sendHtmlMessage(Order order) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
        helper.setTo("kirill_alexandr0vich@mail.ru");
        helper.setSubject("Заказ #" + order.getId());
        Context context = new Context();
        context.setVariable("name", order);
        String html = springTemplateEngine.process("letterSeller.html", context);
        helper.setText(html, true);
        javaMailSender.send(message);
    }
}
