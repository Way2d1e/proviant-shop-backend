package ru.shop.proviant.model.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity(name = "orders_items")
public class OrderItem {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "weight")
    private Double weight;

    @ManyToOne(cascade = CascadeType.MERGE)
//    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id",scope = Product.class)
//    @JsonIdentityReference(alwaysAsId = true)
    @JoinColumn(name = "product_id")
    private Product product;

}
