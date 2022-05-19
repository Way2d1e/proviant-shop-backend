package ru.shop.proviant.model.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name = "orders")
@CrossOrigin
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
    private Date date;

    @Column(name = "price_order")
    private BigDecimal price;

    @Column(name = "email_client")
    private String email;

}
