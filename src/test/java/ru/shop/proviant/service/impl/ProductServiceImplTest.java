package ru.shop.proviant.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.shop.proviant.model.entity.Product;
import ru.shop.proviant.repository.ProductRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {
    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductRepository productRepository;

    private final Long id = 1L;

    @Test
    void getListProductTest() {
    }

    @Test
    void saveProductTest() {
    }

    private Optional<Product> generateProduct() {
        return Optional.of(new Product());
    }

    // два состояния: когда есть id, и когда id не существует
    //  return productRepository.deleteById(id);
    @Test
    void deleteProductWithNullIdTest() {

        productRepository.deleteById(id);
        assertNull(productRepository.findById(id));
    }
}