package ru.shop.proviant.service.impl;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import ru.shop.proviant.model.dto.OrderDto;
import ru.shop.proviant.model.entity.Order;
import ru.shop.proviant.model.entity.Product;
import ru.shop.proviant.service.EmailSenderService;

import javax.mail.MessagingException;
import java.util.List;

class EmailSenderImplTest {



    @InjectMocks
    private EmailSenderService emailSenderService;

    @Mock
    private EmailSenderImpl emailSenderImpl;

    @Mock
    private List<Product> productList;

    @Mock
    private Order order;

    @Mock
    private OrderDto orderDto;


    @Test
    void sendEmails() throws MessagingException {
        emailSenderService.sendEmails(order, orderDto, productList);


    }

    @Test
    void sendHtmlMessage() {
    }
}