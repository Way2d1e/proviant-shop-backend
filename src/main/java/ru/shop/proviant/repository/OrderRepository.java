package ru.shop.proviant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shop.proviant.model.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
