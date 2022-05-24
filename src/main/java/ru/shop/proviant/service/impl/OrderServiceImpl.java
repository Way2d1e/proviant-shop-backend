package ru.shop.proviant.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shop.proviant.model.entity.Order;
import ru.shop.proviant.model.entity.OrderItem;
import ru.shop.proviant.model.entity.Product;
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
            sumPriceAllOrders = sumPriceAllOrders.add(price);
        }
        return sumPriceAllOrders;
    }

    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @Override
    public BigDecimal setAllPrices(List<OrderItem> orderItem, List<Product> productList) {
        BigDecimal sumWholeOrder = BigDecimal.ZERO;
        for (int productIndex = 0; productIndex < orderItem.size(); productIndex++) {
            BigDecimal price = productList.get(productIndex).getPrice();
            double weight = orderItem.get(productIndex).getWeight();
            double itemPrice = price.intValue() * weight;
            sumWholeOrder = sumWholeOrder.add(BigDecimal.valueOf(itemPrice));
            orderItem.get(productIndex).setPrice(BigDecimal.valueOf(itemPrice));
        }
        return sumWholeOrder;
    }
}
