package ru.shop.proviant.model;


import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Entity(name = "order")
public class Order{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
