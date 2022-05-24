package ru.shop.proviant.model.dto;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrderItemDto {


    @NotNull
    private Long productId;

    @NotNull
    private Double weight;

}
