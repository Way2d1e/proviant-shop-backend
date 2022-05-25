package ru.shop.proviant.model.dto;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrderItemDto {

    private Long productId;
    private Double weight;

}
