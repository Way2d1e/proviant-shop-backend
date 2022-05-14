package ru.shop.proviant.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.shop.proviant.model.Order;
import ru.shop.proviant.repository.OrderRepository;
import ru.shop.proviant.services.OrderService;

import javax.mail.MessagingException;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderRepository orderRepository;

    private final OrderService orderService;

    @CrossOrigin
    @PostMapping
    public Order saveAll(@RequestBody Order orders){
        return orderService.saveOrder(orders);
    }

    @GetMapping
    public ResponseEntity getAll(){
        return orderService.findAll();
    }

}