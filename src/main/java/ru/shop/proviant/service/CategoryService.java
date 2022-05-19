package ru.shop.proviant.service;

import ru.shop.proviant.model.entity.Category;
import ru.shop.proviant.model.entity.Product;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getCategories();

    List<Product> getAllProductFromCategory(Long id);
}
