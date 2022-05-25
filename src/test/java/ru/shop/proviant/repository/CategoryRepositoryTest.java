package ru.shop.proviant.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.shop.proviant.model.entity.Category;

import java.util.Optional;

@SpringBootTest
class CategoryRepositoryTest {
    @Autowired
    private CategoryRepository categoryRepository;


    public Category generateCategory() {
        Category category = new Category();
        category.setName("fasdfa");
        category.setImagePath("/src");
        category.setNameEnglish("hubve");
        return category;
    }
    @Test
    public void testFoo() {
        Category category = categoryRepository.save(generateCategory());
        Optional<Category> byId = categoryRepository.findById(category.getId());
        Category category1 = byId.orElseThrow(() -> new RuntimeException("Allax"));
        Assertions.assertEquals("fasdfa", category1.getName());

    }

}