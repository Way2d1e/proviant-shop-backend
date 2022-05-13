package ru.shop.proviant.controller;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.shop.proviant.config.MapperConfig;
import ru.shop.proviant.dto.ProductDto;
import ru.shop.proviant.model.Product;
import ru.shop.proviant.repository.ProductRepository;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductRepository productRepository;

    private ModelMapper modelMapper;

    @CrossOrigin
    @GetMapping
    public List<ProductDto> getAllProduct() {
        List<Product> posts = productRepository.findAll();
        return MapperConfig.convertList(posts, this::convertToProductDto);
    }

    private ProductDto convertToProductDto(Product product) {
        ProductDto productDto = modelMapper.map(product, ProductDto.class);
        return productDto;
    }
}

