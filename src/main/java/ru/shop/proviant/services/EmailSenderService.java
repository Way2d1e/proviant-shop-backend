package ru.shop.proviant.services;


import ru.shop.proviant.model.entity.Order;

import javax.mail.MessagingException;



public interface EmailSenderService {

    void sendHtmlMessage(Order order) throws MessagingException;
}
