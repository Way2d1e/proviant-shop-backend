package ru.shop.proviant.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shop.proviant.model.dto.OrderItemDto;
import ru.shop.proviant.model.dto.ProductDto;
import ru.shop.proviant.model.entity.Order;
import ru.shop.proviant.model.entity.OrderItem;
import ru.shop.proviant.model.entity.Product;
import ru.shop.proviant.repository.OrderRepository;
import ru.shop.proviant.repository.ProductRepository;
import ru.shop.proviant.service.OrderService;
import ru.shop.proviant.service.ProductService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;



    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(List<OrderItemDto> orderItemDto) {
        OrderItem orderItem = new OrderItem();
        Product product = new Product();
        for(int i = 0;i < orderItemDto.size(); i++){
          product = productRepository.getById(orderItemDto.get(i).getProductId());
        }
        return product;
    }



    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
