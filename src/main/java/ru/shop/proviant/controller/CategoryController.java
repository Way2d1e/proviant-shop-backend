package ru.shop.proviant.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.shop.proviant.mapper.CategoryMapper;
import ru.shop.proviant.mapper.ProductMapper;
import ru.shop.proviant.model.dto.CategoryDto;
import ru.shop.proviant.model.dto.ProductDto;
import ru.shop.proviant.model.entity.Category;
import ru.shop.proviant.model.entity.Product;
import ru.shop.proviant.service.CategoryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class CategoryController {
    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;
    private final ProductMapper productMapper;

    @GetMapping("/category")
    public List<CategoryDto> getAllCategory() {
        List<Category> categoriesEntity = categoryService.getCategories();

        return categoryMapper.toListDto(categoriesEntity);
    }

    @GetMapping("/category/{categoryId}/product")
    public List<ProductDto> getProduct(@PathVariable Long categoryId) {
        List<Product> listEntityProduct = categoryService.getAllProductFromCategory(categoryId);
        return productMapper.listDto(listEntityProduct);
    }
}
