package ru.shop.proviant.model.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Embeddable;
import javax.validation.constraints.*;

@Embeddable
@Getter
@Setter
public class Client {

    @NotBlank
    @Size(min = 3, max = 15)
    private String surname;
    @NotBlank
    @Size(min = 3, max = 15)
    private String name;
    @NotBlank
    @Size(min = 3, max = 15)
    private String middleName;
    @NotNull
    private Long phoneNumber;
    @NotBlank
    @Email
    private String email;

}
