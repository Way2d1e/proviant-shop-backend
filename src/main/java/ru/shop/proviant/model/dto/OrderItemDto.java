package ru.shop.proviant.model.dto;

import javax.validation.constraints.*;
import javax.validation.executable.ValidateOnExecution;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;

@Data
public class OrderItemDto {

    @NotNull
    private Long productId;

    @NotNull
    @DecimalMin(value = "0.1")
    @DecimalMax(value = "40.0")
    private Double weight;

}
