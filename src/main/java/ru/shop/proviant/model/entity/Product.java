package ru.shop.proviant.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "image")
    private String imagePath;

    @Column(name = "type_measuring")
    private String typeMeasuring;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;

    @JsonIgnore
    @OneToMany(mappedBy = "productId",cascade = CascadeType.MERGE)
    private List<OrderItem> orderItems;

    @Column(name = "default_value")
    private Double defaultValue;

}
