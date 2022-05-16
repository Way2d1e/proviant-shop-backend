package ru.shop.proviant.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "orders_products")
public class OrderProductPrice {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="order_id",nullable = false)
    private Order order;

    @Column(name = "product_id")
    private Integer productID;

    @Column(name = "price_per_product")
    private Integer pricePerProduct;


}
