package ru.shop.proviant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shop.proviant.model.OrderProducts;

public interface OrderProductPriceRepository extends JpaRepository<OrderProducts, Long> {
}
