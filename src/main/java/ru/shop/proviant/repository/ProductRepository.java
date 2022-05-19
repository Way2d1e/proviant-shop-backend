package ru.shop.proviant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.shop.proviant.model.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
