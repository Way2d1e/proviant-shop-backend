package ru.shop.proviant.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.shop.proviant.model.dto.OrderDto;
import ru.shop.proviant.mapper.OrderMapper;
import ru.shop.proviant.model.dto.OrderItemDto;
import ru.shop.proviant.model.entity.Order;
import ru.shop.proviant.model.entity.OrderItem;
import ru.shop.proviant.repository.OrderRepository;
import ru.shop.proviant.service.OrderService;
import ru.shop.proviant.service.impl.EmailSenderImpl;

import javax.mail.MessagingException;
import java.util.List;

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
    public OrderDto saveAll(@RequestBody OrderDto orderDto) throws MessagingException {
        Order order = orderMapper.toDto(orderDto);
        orderService.saveOrder(order);
    //        orderService.sumPerProduct(order.getOrderItems());
//        emailSender.sendHtmlMessage(order,"letterClient.html");
//        emailSender.sendHtmlMessage(order,"letterSeller.html");
        return orderDto;
    }


//    @GetMapping
//    public List<Order> getOrders() {
//        return orderService.getOrders();
//    }

    @GetMapping
    public ResponseEntity getOrders() {
        return ResponseEntity.ok(orderRepository.findAll());
    }



}