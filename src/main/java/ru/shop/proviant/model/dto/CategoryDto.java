package ru.shop.proviant.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class CategoryDto {
    private Integer id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String imagePath;
    @NotEmpty
    private String nameEnglish;
}
