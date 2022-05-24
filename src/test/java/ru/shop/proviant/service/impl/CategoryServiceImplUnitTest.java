package ru.shop.proviant.service.impl;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.shop.proviant.model.entity.Category;
import ru.shop.proviant.model.entity.Product;
import ru.shop.proviant.repository.CategoryRepository;
import ru.shop.proviant.service.CategoryService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CategoryServiceImplUnitTest {
    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServiceImpl categoryService;


    @Test
    public void getCategoriesTest() {
        categoryService.getCategories();
        Mockito.verify(categoryRepository, Mockito.only()).findAll();
    }
    @Test
    void getAllProductFromCategoryTest() {

    }
}