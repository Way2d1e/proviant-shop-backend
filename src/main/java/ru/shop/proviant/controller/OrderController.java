package ru.shop.proviant.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;
import ru.shop.proviant.mapper.OrderMapper;
import ru.shop.proviant.model.dto.OrderDto;
import ru.shop.proviant.model.entity.Order;
import ru.shop.proviant.model.entity.Product;
import ru.shop.proviant.service.OrderService;
import ru.shop.proviant.service.ProductService;
import ru.shop.proviant.service.impl.EmailSenderImpl;

import javax.mail.MessagingException;
import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin
@RequiredArgsConstructor
@EnableAsync
public class OrderController {

    private final OrderService orderService;
    private final ProductService productService;
    private final OrderMapper orderMapper;
    private final EmailSenderImpl emailSender;


    @PostMapping
    public void saveAll(@RequestBody OrderDto orderDto) throws MessagingException {
        Order order = orderMapper.toEntity(orderDto);
        List<Product> productList = productService.getListProduct(orderDto.getOrderItems());
        order.setPrice(orderService.setAllPrices(order.getOrderItems(), productList));
        orderService.saveOrder(order);
        getId(order);
        emailSender.sendHtmlMessage(productList, order, "letterClient.html");
        emailSender.sendHtmlMessage(productList, order, "letterSeller.html");
    }

    @Async
    Long getId(Order order){
        return order.getId();
    }


    @GetMapping
    public List<Order> getOrders() {
        return orderService.getOrders();
    }


}