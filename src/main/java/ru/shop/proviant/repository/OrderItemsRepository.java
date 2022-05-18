package ru.shop.proviant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shop.proviant.model.OrderItems;

public interface OrderItemsRepository extends JpaRepository<OrderItems, Long> {
}
