package ru.shop.proviant.dto;

import lombok.Data;


@Data
public class OrderItemsDto {


    private Integer id;

    private Integer productID;

    private Integer pricePerProduct;

    private String productName;

    private Double weight;

    private String measuringType;

}
