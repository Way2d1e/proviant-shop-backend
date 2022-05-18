package ru.shop.proviant.services;


import ru.shop.proviant.dto.OrderDto;
import ru.shop.proviant.model.Order;

import javax.mail.MessagingException;



public interface EmailSenderService {

    void sendHtmlMessage(Order order) throws MessagingException;
}
