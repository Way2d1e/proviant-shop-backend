package ru.shop.proviant.model.entity;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name = "orders")
public class Order {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @NotEmpty
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private List<OrderItem> orderItems;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "surname", column = @Column(name = "surname_client")),
            @AttributeOverride(name = "name", column = @Column(name = "name_client")),
            @AttributeOverride(name = "middleName", column = @Column(name = "middlename_client")),
            @AttributeOverride(name = "phoneNumber", column = @Column(name = "phonenumber_client")),
            @AttributeOverride(name = "email", column = @Column(name = "email_client"))
    })
    private Client client;

    @Column(name = "date_order")
    @CreationTimestamp
    private Date date;

    @Column(name = "price_order")
    private BigDecimal price;


}
