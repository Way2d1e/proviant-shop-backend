package ru.shop.proviant.service.impl;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ru.shop.proviant.repository.ProductRepository;

class ProductServiceImplTest {
    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductRepository productRepository;

    @Test
    void getListProductTest() {
    }

    @Test
    void saveProductTest() {
    }

    // два состояния: когда есть id, и когда id не существует
    @Test
    void deleteProductTest() {
    }
}