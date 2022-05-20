package ru.shop.proviant.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shop.proviant.model.entity.Order;
import ru.shop.proviant.model.entity.OrderItem;
import ru.shop.proviant.model.entity.Product;
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
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }



    BigDecimal itemCost  = BigDecimal.ZERO;
    BigDecimal totalCost = BigDecimal.ZERO;

    @Override
    public BigDecimal sumPerProduct(List<OrderItem> orderItem) {
        BigDecimal sum = BigDecimal.ZERO;
        for (int orderIndex = 0;orderIndex < orderItem.size(); orderIndex++) {
             BigDecimal price = orderItem.get(orderIndex).getProduct().getPrice();
             double weight = orderItem.get(orderIndex).getWeight();
             double itemPrice = price.intValue() * weight;
             sum = sum.add(BigDecimal.valueOf(itemPrice));
             orderItem.get(orderIndex).setPrice(sum);
        }
        return itemCost ;
    }
}
