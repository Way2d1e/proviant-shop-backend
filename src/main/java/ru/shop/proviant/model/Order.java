package ru.shop.proviant.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name = "orders")
public class Order {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "orders_id",referencedColumnName = "id")
    private List<OrderItems> orderItems;

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
