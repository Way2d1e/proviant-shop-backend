package ru.shop.proviant.service;

import ru.shop.proviant.model.entity.Order;

import javax.mail.MessagingException;
import java.math.BigDecimal;
import java.util.List;

public interface OrderService {

    void saveOrder(Order order) throws MessagingException;
    BigDecimal sumPriceAllOrders();

    List<Order> getCategory();
}
