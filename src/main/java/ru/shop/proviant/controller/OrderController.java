package ru.shop.proviant.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.shop.proviant.mapper.OrderMapper;
import ru.shop.proviant.model.dto.OrderDto;
import ru.shop.proviant.model.entity.Order;
import ru.shop.proviant.model.entity.Product;
import ru.shop.proviant.repository.OrderRepository;
import ru.shop.proviant.service.EmailSenderService;
import ru.shop.proviant.service.OrderService;
import ru.shop.proviant.service.ProductService;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/order")
@CrossOrigin
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final ProductService productService;
    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;
    private final EmailSenderService emailSenderService;

    @PostMapping
    public Long saveAll(@Valid @RequestBody OrderDto orderDto) throws MessagingException {
        Order order = orderMapper.toEntity(orderDto);
        List<Product> productList = productService.getListProduct(orderDto.getOrderItems());
        order.setPrice(orderService.setAllPrices(order.getOrderItems(), productList));
        orderService.saveOrder(order);
        log.info("saveAll and send email");
        emailSenderService.sendEmails(order, orderDto, productList);
        log.info("after saveAll and sent email");
        return order.getId();
    }


    @GetMapping
    public List<Order> getOrders() {
        return orderService.getOrders();
    }

    @GetMapping("/{id}")
    public ResponseEntity getOrderById(@PathVariable Long id){
        return ResponseEntity.ok(orderRepository.findById(id));
    }


}