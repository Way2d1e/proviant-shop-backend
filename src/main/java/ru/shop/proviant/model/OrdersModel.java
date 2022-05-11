package ru.shop.proviant.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class OrdersModel {

    @Id
    private Long id;

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
