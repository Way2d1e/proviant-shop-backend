package ru.shop.proviant.model.dto;


import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.validation.annotation.Validated;
import ru.shop.proviant.model.entity.Client;

import java.util.List;

@Data
public class OrderDto {

    @NotNull
    private List<OrderItemDto> orderItems;

    @NotNull
    private Client client;

}
