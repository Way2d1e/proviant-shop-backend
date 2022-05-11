package ru.shop.proviant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shop.proviant.model.OrdersModel;

public interface OrderRepository extends JpaRepository<OrdersModel, Long> {
}
