package ru.shop.proviant.dto;


import lombok.Data;
import ru.shop.proviant.model.OrderItems;

import java.util.Date;
import java.util.List;

@Data
public class OrderDto {

    private Long id;

    private List<OrderItems> orderItems;

    private String surname;

    private String name;

    private String middleName;

    private Long phoneNumber;

    private Date orderDate;

    private Integer orderPrice;

    private String email;


}