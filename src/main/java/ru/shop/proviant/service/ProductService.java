package ru.shop.proviant.service;

import ru.shop.proviant.model.dto.ProductDto;
import ru.shop.proviant.model.entity.Product;

public interface ProductService {
    Product saveProduct(Product product);
    void deleteProduct(Long id);
}
