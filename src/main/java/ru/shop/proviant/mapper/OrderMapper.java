package ru.shop.proviant.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.shop.proviant.model.dto.OrderDto;
import ru.shop.proviant.model.entity.Order;

import java.util.List;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

//    @Mapping(source = "id", target = "id")
    Order toDto(OrderDto orderDto);

    Order convertDtoToEntity(OrderDto orderDto);

    List<OrderDto> convertListEntityToListDto(List<Order> orders);


}
