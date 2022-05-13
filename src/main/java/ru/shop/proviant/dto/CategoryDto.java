package ru.shop.proviant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoryDto {
    private Integer id;

    private String name_category;
    private String image_category;
}
