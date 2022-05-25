package ru.shop.proviant.model.dto;

import javax.validation.constraints.*;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

@Data
public class OrderItemDto {

    @NotNull
    private Long productId;

    @NotNull
    @DecimalMin("0.0")
    @DecimalMax("40.0")
    private Double weight;

}
