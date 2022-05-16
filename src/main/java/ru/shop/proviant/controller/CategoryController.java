package ru.shop.proviant.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.shop.proviant.mappers.CategoryMapper;
import ru.shop.proviant.model.dto.CategoryDto;
import ru.shop.proviant.model.entity.Category;
import ru.shop.proviant.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
@CrossOrigin
public class CategoryController {
    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @GetMapping
    public List<CategoryDto> getAllCategory() {
        List<Category> categories = categoryService.getCategories();
        return categoryMapper.toListDto(categories);
    }
}
