package ru.shop.proviant.service;

import ru.shop.proviant.model.dto.OrderItemDto;
import ru.shop.proviant.model.entity.Product;

import java.util.List;

public interface ProductService {


    List<Product> getListProduct(List<OrderItemDto> orderItemDtoList);

    Product saveProduct(Product product);

    void deleteProduct(Long id);


}
