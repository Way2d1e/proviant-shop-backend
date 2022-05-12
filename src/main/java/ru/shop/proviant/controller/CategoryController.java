package ru.shop.proviant.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.shop.proviant.repository.CategoryRepository;

@RestController
@AllArgsConstructor
public class CategoryController {

    private final CategoryRepository categoryRepository;

    @CrossOrigin
    @GetMapping(value = "/category")
    public ResponseEntity getAllCategory(){
       return ResponseEntity.ok(categoryRepository.findAll());
    }


}
