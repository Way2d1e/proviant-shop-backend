package ru.shop.proviant.model.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import ru.shop.proviant.model.EntityIdResolver;
import ru.shop.proviant.model.entity.Product;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderItemDto {

    @JsonIdentityReference(alwaysAsId = true)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id",scope = Product.class,resolver = EntityIdResolver.class)
    private Product product;

    private Double weight;

    private BigDecimal price;
}
