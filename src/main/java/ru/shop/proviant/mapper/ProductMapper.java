package ru.shop.proviant.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.shop.proviant.model.entity.dto.ProductDto;
import ru.shop.proviant.model.entity.Product;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto toDto(Product product);

    Product dtoToEntity(ProductDto productDto);

    List<ProductDto> listDto(List<Product> products);
}
