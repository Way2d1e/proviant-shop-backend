package ru.shop.proviant.model.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Embeddable
@Getter
@Setter
public class Client {

    @NotBlank(message = "Фамилия")
    private String surname;
    @NotBlank
    private String name;
    @NotBlank
    private String middleName;
    @NotNull
    private Long phoneNumber;
    @NotBlank
    private String email;

}
