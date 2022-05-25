package ru.shop.proviant.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String imagePath;

    @Column(name = "name_en")
    private String nameEnglish;

    @OneToMany(mappedBy = "category")
    private List<Product> productList;
}
