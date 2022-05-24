package ru.shop.proviant.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private Long id;
    private String name;
    private Long categoryId;
    private Integer price;
    private String imagePath;
    private String typeMeasuring;
    private Double defaultValue;

}
