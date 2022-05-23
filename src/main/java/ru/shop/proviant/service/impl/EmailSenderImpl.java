package ru.shop.proviant.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import ru.shop.proviant.config.DataFormatter;
import ru.shop.proviant.config.propetries.MailProperties;
import ru.shop.proviant.model.entity.Order;
import ru.shop.proviant.model.entity.Product;
import ru.shop.proviant.service.EmailSenderService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.util.List;


@Service
@RequiredArgsConstructor
public class EmailSenderImpl implements EmailSenderService {

    private final String ORDER_INDEX = "Заказ #";
    private final JavaMailSender javaMailSender;
    private final SpringTemplateEngine springTemplateEngine;
    private final MailProperties mailProperties;


    @Override
    public void sendHtmlMessage(List<Product> productList, Order order, String template) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
        if(template.equals(mailProperties.getTemplateName())){
            helper.setTo(mailProperties.getSellerMail());
        }else {
            helper.setTo(order.getClient().getEmail());
        }
        helper.setSubject(ORDER_INDEX + order.getId());
        DataFormatter dataFormatter = new DataFormatter(order);
        Context context = new Context();
        context.setVariable("dateFormat", dataFormatter);
        context.setVariable("order", order);
        context.setVariable("productList", productList);
        String html = springTemplateEngine.process(template, context);
        helper.setText(html, true);
        javaMailSender.send(message);
    }
}
