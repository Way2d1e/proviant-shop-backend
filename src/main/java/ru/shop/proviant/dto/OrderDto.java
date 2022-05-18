package ru.shop.proviant.dto;


import lombok.Data;
import ru.shop.proviant.model.OrderItems;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;
import java.util.List;

@Data
public class OrderDto {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private List<OrderItems> orderItems;

    private String surname;

    private String name;

    private String middleName;

    private Long phoneNumber;

    private Date orderDate;

    private Integer orderPrice;

    private String email;


}
