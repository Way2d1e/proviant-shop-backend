package ru.shop.proviant.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.shop.proviant.model.Orders;
import ru.shop.proviant.repository.OrderRepository;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;

    @PostMapping
    public Orders getAllCategory(@RequestBody Orders orders){
        return orderRepository.save(orders);
    }
}