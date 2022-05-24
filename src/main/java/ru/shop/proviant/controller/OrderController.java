package ru.shop.proviant.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.shop.proviant.mapper.OrderMapper;
import ru.shop.proviant.model.dto.OrderDto;
import ru.shop.proviant.model.entity.Order;
import ru.shop.proviant.repository.OrderRepository;
import ru.shop.proviant.service.OrderService;
import ru.shop.proviant.service.impl.EmailSenderImpl;

import javax.mail.MessagingException;

@RestController
@RequestMapping("/order")
@CrossOrigin
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;
    private final EmailSenderImpl emailSender;
    private final OrderRepository orderRepository;

    @PostMapping
    public Long saveAll(@RequestBody OrderDto orderDto) throws MessagingException {
        Order order = orderMapper.toEntity(orderDto);
        order.setPrice(orderService.pricePerProduct(order.getOrderItems()));
        orderService.saveOrder(order);
        emailSender.sendHtmlMessage(order, "letterClient.html");
        emailSender.sendHtmlMessage(order, "letterSeller.html");
        return order.getId();
    }


    @GetMapping
    public ResponseEntity getOrders() {
        return ResponseEntity.ok(orderRepository.findAll());
    }


}