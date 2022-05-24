package ru.shop.proviant.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shop.proviant.model.dto.OrderItemDto;
import ru.shop.proviant.model.entity.Product;
import ru.shop.proviant.repository.ProductRepository;
import ru.shop.proviant.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;


    @Override
    public List<Product> getListProduct(List<OrderItemDto> orderItemDtoList) {
        List<Long> idList = new ArrayList<>();
        for (int indexItems = 0; indexItems < orderItemDtoList.size(); indexItems++) {
            idList.add(orderItemDtoList.get(indexItems).getProductId());
        }
        return productRepository.findAllById(idList);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
