package ru.shop.proviant.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shop.proviant.model.entity.Order;
import ru.shop.proviant.repository.OrderRepository;
import ru.shop.proviant.service.OrderService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;


    @Override
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public BigDecimal sumPriceAllOrders() {
        List<Order> orders = orderRepository.findAll();
        List<BigDecimal> priceOrders = new ArrayList<>();
        for(Order price : orders) {
            priceOrders.add(price.getPrice());
        }
        BigDecimal sumPriceAllOrders = BigDecimal.ZERO;
        for (BigDecimal price : priceOrders) {
            sumPriceAllOrders.add(price);
        }
        return sumPriceAllOrders;
    }

    @Override
    public List<Order> getCategory() {
        return orderRepository.findAll();
    }


}
