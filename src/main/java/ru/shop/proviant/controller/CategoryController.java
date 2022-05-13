package ru.shop.proviant.controller;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.shop.proviant.dto.CategoryDto;
import ru.shop.proviant.model.Category;
import ru.shop.proviant.repository.CategoryRepository;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private final CategoryRepository categoryRepository;


    public CategoryController(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
    }

    @CrossOrigin
    @GetMapping("/category")
    public List<Category> getAllCategory() {
        List<Category> categories = categoryRepository.findAll();
        return categories/*MapperUtil.convertList(categories, this::convertToCategoryDto)*/;
    }

    private CategoryDto convertToCategoryDto(Category category) {
        return modelMapper.map(category, CategoryDto.class);
    }


}
