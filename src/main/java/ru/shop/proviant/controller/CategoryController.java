package ru.shop.proviant.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.shop.proviant.repository.CategoryRepository;

@RestController
@RequestMapping("/product")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public ResponseEntity getAllCategory(){
        return ResponseEntity.ok(this.categoryRepository.findAll());
    }


}
