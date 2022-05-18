package ru.shop.proviant.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.shop.proviant.dto.OrderDto;
import ru.shop.proviant.dto.OrderItemsDto;
import ru.shop.proviant.model.Order;
import ru.shop.proviant.model.OrderItems;

import java.util.List;

@Mapper
public interface OrderItemsMapper {

    OrderItemsMapper INSTANCE = Mappers.getMapper(OrderItemsMapper.class);

    @Mapping(source = "weight",target = "weight")
    List<OrderDto> toDto(List<OrderItems> orderItems);


}
