package ru.shop.proviant.services.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shop.proviant.dto.OrderDto;
import ru.shop.proviant.dto.OrderItemsDto;
import ru.shop.proviant.mapper.OrderItemsMapper;
import ru.shop.proviant.model.Order;
import ru.shop.proviant.model.OrderItems;
import ru.shop.proviant.repository.OrderItemsRepository;
import ru.shop.proviant.repository.OrderRepository;
import ru.shop.proviant.services.OrderService;

import java.util.List;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderItemsRepository orderItemsRepository;

    @Override
    public Order saveOrder(Order order){
        return orderRepository.save(order);
    }

    @Override
    public OrderItems saveOrderItems(OrderItems orderItems) {
        return orderItemsRepository.save(orderItems);
    }

    @Override
    public List<Order> getCategories() {
        return orderRepository.findAll();
    }
}
