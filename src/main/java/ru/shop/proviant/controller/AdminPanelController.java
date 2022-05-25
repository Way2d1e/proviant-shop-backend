package ru.shop.proviant.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.shop.proviant.mapper.ProductMapper;
import ru.shop.proviant.model.dto.ProductDto;
import ru.shop.proviant.model.entity.Product;
import ru.shop.proviant.service.OrderService;
import ru.shop.proviant.service.ProductService;

import javax.validation.Valid;
import java.math.BigDecimal;

//@CrossOrigin
@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
@Validated
public class AdminPanelController {
    private final ProductService productService;
    private final OrderService orderService;
    private final ProductMapper productMapper;


    @PostMapping("/product") // ready
    public ProductDto addProduct(@RequestBody @Valid ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        productService.saveProduct(product);
        return productMapper.toDto(product);
    }

    @DeleteMapping("/delete/{id}") // ready
    public void deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/order/price") // ready
    public BigDecimal getAllPriceProducts() {
        BigDecimal sum = orderService.sumPriceAllOrders();

        return sum;
    }

}
