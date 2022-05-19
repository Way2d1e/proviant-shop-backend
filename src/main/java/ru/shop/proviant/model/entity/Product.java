package ru.shop.proviant.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity(name = "product")
@CrossOrigin
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "image")
    private String imagePath;

    @Column(name = "type_measuring")
    private String typeMeasuring;

    @Column(name = "default_value")
    private Double defaultValue;
}
