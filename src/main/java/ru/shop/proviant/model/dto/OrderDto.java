package ru.shop.proviant.model.dto;


import lombok.Data;
import ru.shop.proviant.model.entity.Client;

import java.util.List;

@Data
public class OrderDto {

    private List<OrderItemDto> orderItems;

    private Client client;


}
