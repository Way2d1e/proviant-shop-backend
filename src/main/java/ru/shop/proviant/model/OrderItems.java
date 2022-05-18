package ru.shop.proviant.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "orders_items")
public class OrderItems {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id")
    private Integer productID;

    @Column(name = "price_per_product")
    private Integer pricePerProduct;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "measuring_type")
    private String measuringType;

}
