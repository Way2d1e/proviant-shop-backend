package ru.shop.proviant.model.dto;

import lombok.Data;

@Data
public class ClientDto {

    private String surname;

    private String name;

    private String middleName;

    private Long phoneNumber;

    private String email;

}
