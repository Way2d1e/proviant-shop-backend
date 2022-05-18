package ru.shop.proviant.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.shop.proviant.dto.OrderDto;
import ru.shop.proviant.mapper.OrderMapper;
import ru.shop.proviant.model.Order;
import ru.shop.proviant.services.OrderService;
import ru.shop.proviant.services.impl.EmailSenderImpl;

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

    @PostMapping
    public OrderDto saveAll(@RequestBody OrderDto orderDto) throws MessagingException {
        Order order = orderMapper.toDto(orderDto);
        orderService.saveOrder(order);
        emailSender.sendHtmlMessage(order);
        return orderDto;
    }


    @GetMapping
    public List<Order> getAllCategory() {
        return orderService.getCategory();
    }

}