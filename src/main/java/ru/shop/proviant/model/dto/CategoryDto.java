package ru.shop.proviant.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoryDto {
    private Integer id;
    private String name;
    private String imagePath;
}
