package ru.shop.proviant.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@Entity(name = "orders_items")
public class OrderItem {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "price")
    private BigDecimal price;

    @NotNull
    @DecimalMin(value = "0.1")
    @DecimalMax(value = "40.0")
    @Column(name = "weight")
    private Double weight;

    @NotNull
    @Column(name = "product_id")
    private Long productId;

}
