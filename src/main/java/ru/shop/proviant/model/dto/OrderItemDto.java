package ru.shop.proviant.model.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import ru.shop.proviant.model.EntityIdResolver;
import ru.shop.proviant.model.entity.Product;

import java.math.BigDecimal;

@Data
public class OrderItemDto {

    @JsonIdentityReference(alwaysAsId = true)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id",scope = Product.class,resolver = EntityIdResolver.class)
    private Product productId;

    private Double weight;
}
