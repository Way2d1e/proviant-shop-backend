package ru.shop.proviant.service;


import ru.shop.proviant.model.entity.Order;

import javax.mail.MessagingException;


public interface EmailSenderService {

    void sendHtmlMessage(Order order, String template) throws MessagingException;
}
