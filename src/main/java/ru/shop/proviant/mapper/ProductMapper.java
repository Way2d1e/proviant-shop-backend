package ru.shop.proviant.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.shop.proviant.model.dto.ProductDto;
import ru.shop.proviant.model.entity.Product;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(source = "defaultValue", target = "defaultValue")
    @Mapping(source = "price", target = "price")
    ProductDto toDto(Product product);

    @Mapping(source = "id", target = "id")
    Product dtoToEntity(ProductDto productDto);

    @Mapping(source = "categoryId", target = "category.id")
    List<ProductDto> listDto(List<Product> products);

    @Mapping(source = "categoryId", target = "category.id")
    @Mapping(source = "price", target = "price")
    Product toEntity(ProductDto productDto);

}
