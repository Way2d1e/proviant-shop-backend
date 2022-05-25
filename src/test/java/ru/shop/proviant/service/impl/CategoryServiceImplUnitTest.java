package ru.shop.proviant.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.shop.proviant.model.entity.Product;
import ru.shop.proviant.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
class CategoryServiceImplUnitTest {

    private final Long id = 1L;
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
    void getAllProductFromCategoryNegativeTest() {
        Mockito.when(categoryRepository.findById(id)).thenReturn(Optional.empty());
        List<Product> allProductFromCategory = categoryService.getAllProductFromCategory(id);
        assertNull(allProductFromCategory);

    }
}