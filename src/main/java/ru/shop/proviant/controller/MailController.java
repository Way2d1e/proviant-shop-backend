package ru.shop.proviant.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.shop.proviant.repository.OrderRepository;

@Controller
@RequiredArgsConstructor
public class MailController {

    private final OrderRepository orderRepository;

    public final JavaMailSender emailSender;


    @ResponseBody
    @RequestMapping("/sendEmail")
    public String sendSimpleEmail() {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(orderRepository.getById(1L).getEmail_client());
        message.setSubject("Order");
        message.setText("Имя - " + orderRepository.getById(1L).getName_client() + "\n Дата заказа - "
                + orderRepository.getById(1L).getDate_order().toString() + "\n Электроная почта клиента - "
                + orderRepository.getById(1L).getEmail_client()
        );

        this.emailSender.send(message);

        return "Email sent";
    }
}
