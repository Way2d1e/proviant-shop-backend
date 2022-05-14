package ru.shop.proviant.dto;

import lombok.Data;

import java.util.Date;

@Data
public class OrdersDto {

    private String surname_client;

    private String name_client;

    private String middlename_client;

    private Integer phonenumber_client;

    private Date date_order;

    private Integer price_order;

    private String status_order;

    private String promo_code;

    private String email_client;
}

