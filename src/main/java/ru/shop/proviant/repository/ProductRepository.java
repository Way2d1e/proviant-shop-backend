package ru.shop.proviant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shop.proviant.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
