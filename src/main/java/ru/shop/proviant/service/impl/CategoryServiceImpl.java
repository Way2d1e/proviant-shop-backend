package ru.shop.proviant.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shop.proviant.model.entity.Category;
import ru.shop.proviant.model.entity.Product;
import ru.shop.proviant.repository.CategoryRepository;
import ru.shop.proviant.service.CategoryService;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }
    @Override
    public List<Product> getAllProductFromCategory(Long id) {
        return categoryRepository.findById(id).map(Category::getProductList).orElse(null);
    }
}
