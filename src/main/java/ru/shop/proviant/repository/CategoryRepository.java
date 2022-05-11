package ru.shop.proviant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shop.proviant.model.CategoryModel;

public interface CategoryRepository extends JpaRepository<CategoryModel, Long> {
}
