package ru.shop.proviant.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Integer id;

    private Integer category_id;

    private String name_product;

    private Integer price_product;

    private String type_measuring;

//    @JsonProperty("category")
//    private CategoryDto categoryDto;
}
