package ru.shop.proviant.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    private int id;     // Не работает так как в таблице id integer[] а @id не может быть integer[]

    private int category_id;

    private String name_product;

    private Integer price_product;

    public Product() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public Integer getPrice_product() {
        return price_product;
    }

    public void setPrice_product(Integer price_product) {
        this.price_product = price_product;
    }
}
