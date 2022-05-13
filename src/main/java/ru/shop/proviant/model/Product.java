package ru.shop.proviant.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Product {
    private Integer id;
    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    private Integer category_id;

    private String name_product;

    private Integer price_product;

    private String type_measuring;}
