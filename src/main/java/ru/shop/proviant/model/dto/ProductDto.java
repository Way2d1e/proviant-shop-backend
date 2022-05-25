package ru.shop.proviant.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private Long id;
    @NotBlank
    private String name;
    @NotNull
    private Long categoryId;
    @NotNull
    private BigDecimal price;
    @NotBlank
    private String imagePath;
    @NotBlank
    private String typeMeasuring;
    @NotNull
    private Double defaultValue;

}
