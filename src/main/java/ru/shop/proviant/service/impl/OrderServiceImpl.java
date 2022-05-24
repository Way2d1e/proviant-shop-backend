package ru.shop.proviant.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shop.proviant.model.entity.Order;
import ru.shop.proviant.model.entity.OrderItem;
import ru.shop.proviant.repository.OrderRepository;
import ru.shop.proviant.service.OrderService;

import java.math.BigDecimal;
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

        BigDecimal sumPriceAllOrders = BigDecimal.ZERO;
        for (int orderIndex = 0; orderIndex < orders.size(); orderIndex++) {
            BigDecimal price = orders.get(orderIndex).getPrice();
            if (price == null) {
                throw new NullPointerException("Price order is null");
            }

            sumPriceAllOrders = sumPriceAllOrders.add(price);
        }

        if (sumPriceAllOrders.equals(BigDecimal.ZERO)) {
            sumPriceAllOrders = BigDecimal.ZERO;
        }

        return sumPriceAllOrders;
    }

    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @Override
    public BigDecimal pricePerProduct(List<OrderItem> orderItem) {
        BigDecimal sum = BigDecimal.ZERO;
        for (int orderIndex = 0;orderIndex < orderItem.size(); orderIndex++) {
             BigDecimal price = orderItem.get(orderIndex).getProductId().getPrice();
             double weight = orderItem.get(orderIndex).getWeight();
             double itemPrice = price.intValue() * weight;
             sum = sum.add(BigDecimal.valueOf(itemPrice));
             orderItem.get(orderIndex).setPrice(BigDecimal.valueOf(itemPrice));
        }
        return sum;
    }
}
