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
public class OrderController {

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    private final OrderService orderService;
    @CrossOrigin
    @PostMapping
    public ResponseEntity saveAll(@RequestBody Order orders){
       return ResponseEntity.ok(orderService.saveOrder(orders));
    }

    @GetMapping
    public ResponseEntity getAll(){
        return orderService.getAll();
    }

}