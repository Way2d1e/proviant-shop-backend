package ru.shop.proviant.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import ru.shop.proviant.config.DataFormatter;
import ru.shop.proviant.config.propetries.MailProperties;
import ru.shop.proviant.model.dto.OrderDto;
import ru.shop.proviant.model.entity.Order;
import ru.shop.proviant.model.entity.Product;
import ru.shop.proviant.service.EmailSenderService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class EmailSenderImpl implements EmailSenderService {

    private final String ORDER_INDEX = "Заказ #";
    private final JavaMailSender javaMailSender;
    private final SpringTemplateEngine springTemplateEngine;
    private final MailProperties mailProperties;

    @Async
    @Override
    public void sendEmails(Order order, OrderDto orderDto, List<Product> productList) throws MessagingException {
        sendHtmlMessage(productList, order, "letterClient.html");
        sendHtmlMessage(productList, order, "letterSeller.html");
    }

    @Override
    @Async
    public void sendHtmlMessage(List<Product> productList, Order order, String template) throws MessagingException {
        log.info("start sending Email");
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
        log.info("javaMailSender email sent");
    }
}
