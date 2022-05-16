package ru.shop.proviant.model;


import lombok.*;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@Entity(name = "orders")
public class Order{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<OrderProducts> orderProducts;

    @Column(name = "surname_client")
    private String surname;

    @Column(name = "name_client")
    private String name;

    @Column(name = "middlename_client")
    private String middleName;

    @Column(name = "phonenumber_client")
    private Long phoneNumber;

    @Column(name = "date_order")
    private Date orderDate;

    @Column(name = "price_order")
    private Integer orderPrice;

    @Column(name = "email_client")
    private String email;

}
