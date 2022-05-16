package ru.shop.proviant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shop.proviant.model.OrderProductPrice;

public interface OrderProductPriceRepository extends JpaRepository<OrderProductPrice, Integer> {
}
