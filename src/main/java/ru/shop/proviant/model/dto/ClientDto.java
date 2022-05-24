package ru.shop.proviant.model.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ClientDto {

    @NotEmpty
    private String surname;
    @NotEmpty
    private String name;
    @NotEmpty
    private String middleName;
    @NotNull
    private Long phoneNumber;
    @NotEmpty
    private String email;

}
