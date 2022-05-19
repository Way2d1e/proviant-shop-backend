package ru.shop.proviant.services.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shop.proviant.model.Order;
import ru.shop.proviant.repository.OrderRepository;
import ru.shop.proviant.services.OrderService;

import java.util.List;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;


    @Override
    public Order saveOrder(Order order){
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getCategory() {
        return orderRepository.findAll();
    }


}
