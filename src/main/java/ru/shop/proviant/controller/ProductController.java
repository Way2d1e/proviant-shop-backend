package ru.shop.proviant.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.shop.proviant.mappers.ProductMapper;
import ru.shop.proviant.model.dto.ProductDto;
import ru.shop.proviant.model.entity.Product;
import ru.shop.proviant.service.ProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    @GetMapping("/product")
    public List<ProductDto> getAllProduct() {
        List<Product> products = productService.getProducts();

        return productMapper.listDto(products);
    }
}

