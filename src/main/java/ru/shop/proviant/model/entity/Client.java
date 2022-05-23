package ru.shop.proviant.model.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class Client {

    private String surname;

    private String name;

    private String middleName;

    private Long phoneNumber;

    private String email;

}
