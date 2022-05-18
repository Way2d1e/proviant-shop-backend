package ru.shop.proviant.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.shop.proviant.dto.OrderDto;
import ru.shop.proviant.dto.OrderItemsDto;
import ru.shop.proviant.mapper.OrderItemsMapper;
import ru.shop.proviant.mapper.OrderMapper;
import ru.shop.proviant.model.Order;
import ru.shop.proviant.model.OrderItems;
import ru.shop.proviant.repository.OrderItemsRepository;
import ru.shop.proviant.services.EmailSenderService;
import ru.shop.proviant.services.OrderService;
import ru.shop.proviant.services.impl.EmailSenderImpl;
import ru.shop.proviant.services.impl.OrderServiceImpl;

import javax.mail.MessagingException;
import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final OrderItemsRepository orderItems;
    private final OrderMapper orderMapper;
    private final OrderItemsMapper orderItemsMapper;
    private final EmailSenderImpl emailSender;

    @PostMapping
    public OrderDto saveAll(@RequestBody OrderDto orderDto) throws MessagingException {
        Order order = orderMapper.toDto(orderDto);
        OrderItems orderItems = orderItemsMapper.toDto(orderDto.getOrderItems());
        orderService.saveOrderItems(orderItems)
        orderService.saveOrder(order);
//        emailSender.sendHtmlMessage(orderDto);
        return orderDto;
    }

    @GetMapping
    public List<Order> getAllCategory() {
        return orderService.getCategories();
    }

}