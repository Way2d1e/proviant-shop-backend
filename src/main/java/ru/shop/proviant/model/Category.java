package ru.shop.proviant.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Category {

    @Id
    private Long id;

    private String name_category;

}
