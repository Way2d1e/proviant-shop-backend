package ru.shop.proviant.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDto {
    private Integer id;

    private Long categoryId;

    private String name;

    private Integer price;

    private String imagePath;

    private String typeMeasuring;
}
