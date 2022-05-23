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
import ru.shop.proviant.service.ProductService;
import ru.shop.proviant.service.impl.EmailSenderImpl;
import ru.shop.proviant.service.impl.ProductServiceImpl;

import javax.mail.MessagingException;
import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final ProductService productService;
    private final OrderMapper orderMapper;
    private final EmailSenderImpl emailSender;
    private final OrderRepository orderRepository;

    @PostMapping
    public ProductService saveAll(@RequestBody OrderDto orderDto) throws MessagingException {
        Order order = orderMapper.toEntity(orderDto);
//        order.setPrice(orderService.pricePerProduct(order.getOrderItems()));
//        orderService.saveOrder(order);
//        emailSender.sendHtmlMessage(order,"letterClient.html");
//        emailSender.sendHtmlMessage(order,"letterSeller.html");
        return (ProductService) productService.getProductById(orderDto.getOrderItems());
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