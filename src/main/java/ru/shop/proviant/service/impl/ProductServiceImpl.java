package ru.shop.proviant.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shop.proviant.model.dto.ProductDto;
import ru.shop.proviant.model.entity.Order;
import ru.shop.proviant.model.entity.Product;
import ru.shop.proviant.repository.ProductRepository;
import ru.shop.proviant.service.ProductService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
