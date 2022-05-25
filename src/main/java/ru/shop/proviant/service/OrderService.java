package ru.shop.proviant.service;

import ru.shop.proviant.model.dto.OrderItemDto;
import ru.shop.proviant.model.entity.Order;
import ru.shop.proviant.model.entity.OrderItem;
import ru.shop.proviant.model.entity.Product;

import javax.mail.MessagingException;
import java.math.BigDecimal;
import java.util.List;

public interface OrderService {



    void saveOrder(Order order) throws MessagingException;

    BigDecimal sumPriceAllOrders();
    List<Order> getOrders();
    BigDecimal setAllPrices(List<OrderItem> orderItems,List<Product> productList);
}
