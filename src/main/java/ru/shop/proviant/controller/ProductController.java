package ru.shop.proviant.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.shop.proviant.mappers.ProductMapper;
import ru.shop.proviant.model.dto.ProductDto;
import ru.shop.proviant.model.entity.Product;
import ru.shop.proviant.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
@CrossOrigin
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    @GetMapping
    public List<ProductDto> getAllProduct() {
        List<Product> products = productService.getProducts();
        return productMapper.listDto(products);
    }
}

