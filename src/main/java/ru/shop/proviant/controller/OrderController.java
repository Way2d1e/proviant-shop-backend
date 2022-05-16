package ru.shop.proviant.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.spring5.SpringTemplateEngine;
import ru.shop.proviant.model.Order;
import ru.shop.proviant.services.EmailSenderService;
import ru.shop.proviant.services.OrderService;

import javax.mail.MessagingException;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    private final JavaMailSender emailSender;

    private final SpringTemplateEngine springTemplateEngine;



    @CrossOrigin
    @PostMapping
    public ResponseEntity saveAll(@RequestBody Order orders) throws MessagingException{
       orderService.saveOrder(orders);
       EmailSenderService emailSenderService = new EmailSenderService(emailSender,springTemplateEngine);
       emailSenderService.sendHtmlMessage(orders.getEmail());
       return new ResponseEntity<>("Last stage", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAll(){
        return orderService.getAll();
    }

}