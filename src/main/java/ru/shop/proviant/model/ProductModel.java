package ru.shop.proviant.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class ProductModel {

    @Id
    private Long id;

    private Integer category_id;

    private String name_product;

    private Integer price_product;


}
