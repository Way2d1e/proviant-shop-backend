package ru.shop.proviant.service;


import org.springframework.scheduling.annotation.Async;
import ru.shop.proviant.model.dto.OrderDto;
import ru.shop.proviant.model.entity.Order;
import ru.shop.proviant.model.entity.Product;

import javax.mail.MessagingException;
import java.util.List;


public interface EmailSenderService {

    @Async
    void sendEmails(Order order, OrderDto orderDto, List<Product> productList) throws MessagingException;

    void sendHtmlMessage(List<Product> productList, Order order, String template) throws MessagingException;
}
