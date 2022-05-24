package ru.shop.proviant.service;


import ru.shop.proviant.model.entity.Order;
import ru.shop.proviant.model.entity.Product;

import javax.mail.MessagingException;
import java.util.List;


public interface EmailSenderService {

    void sendHtmlMessage(List<Product> productList, Order order, String template) throws MessagingException;
}
