package ru.shop.proviant.model.dto;

import lombok.Data;
import ru.shop.proviant.model.entity.Product;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderItemDto {

    private Long id;

    private Product product;

    private Double weight;

    private BigDecimal price;
}
