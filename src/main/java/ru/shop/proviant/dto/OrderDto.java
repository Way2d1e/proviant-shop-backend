package ru.shop.proviant.dto;


import lombok.Data;
import ru.shop.proviant.model.OrderProducts;

import java.util.Date;
import java.util.List;


@Data
public class OrderDto {

    private Integer Id;

    private String nameClient;

    private Date dateOrder;

    private Integer priceOrder;

    private List<OrderProducts> orderProducts;

}
