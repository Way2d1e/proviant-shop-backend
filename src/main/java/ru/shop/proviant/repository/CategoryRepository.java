package ru.shop.proviant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shop.proviant.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
