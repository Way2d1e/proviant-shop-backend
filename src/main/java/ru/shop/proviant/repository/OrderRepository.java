package ru.shop.proviant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shop.proviant.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
