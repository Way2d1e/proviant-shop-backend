package ru.shop.proviant.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class UserDto implements Serializable {
    private final Long id;
    private final String username;
    private final String password;
    private final Set<RoleDto> roles;
    private final boolean enabled;
}
