package ru.shop.proviant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shop.proviant.model.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {
}
