package ru.shop.proviant.model.dto;


import lombok.Data;
import org.springframework.validation.annotation.Validated;
import ru.shop.proviant.model.entity.Client;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class OrderDto {

    @NotEmpty(message = "Список продуктов пуст")
    private List<OrderItemDto> orderItems;

    @NotNull(message = "Клиентские данные")
    @Valid
    private Client client;
}
