package ru.shop.proviant.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.shop.proviant.model.dto.OrderDto;
import ru.shop.proviant.mapper.OrderMapper;
import ru.shop.proviant.model.entity.Order;
import ru.shop.proviant.service.OrderService;
import ru.shop.proviant.service.impl.EmailSenderClientImpl;
import ru.shop.proviant.service.impl.EmailSenderSellerImpl;

import javax.mail.MessagingException;
import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;
    private final EmailSenderClientImpl emailSenderClient;
    private final EmailSenderSellerImpl emailSenderSeller;

    @PostMapping
    public OrderDto saveAll(@RequestBody OrderDto orderDto) throws MessagingException {
        Order order = orderMapper.toDto(orderDto);
        orderService.saveOrder(order);
        emailSenderClient.sendHtmlMessage(order);
        emailSenderSeller.sendHtmlMessage(order);
        return orderDto;
    }


    @GetMapping
    public List<Order> getAllCategory() {
        return orderService.getCategory();
    }

}