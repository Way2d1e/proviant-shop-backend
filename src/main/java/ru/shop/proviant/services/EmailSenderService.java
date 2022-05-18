package ru.shop.proviant.services;


import ru.shop.proviant.dto.OrderDto;
import javax.mail.MessagingException;



public interface EmailSenderService {

    void sendHtmlMessage(OrderDto orderDto) throws MessagingException;
}
