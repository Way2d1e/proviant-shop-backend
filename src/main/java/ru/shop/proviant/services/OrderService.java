package ru.shop.proviant.services;

import ru.shop.proviant.model.entity.Order;

import javax.mail.MessagingException;
import java.util.List;

public interface OrderService {

    Order saveOrder(Order order) throws MessagingException;

    List<Order> getCategory();
}
