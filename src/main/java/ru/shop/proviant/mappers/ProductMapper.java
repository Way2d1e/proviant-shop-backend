package ru.shop.proviant.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.shop.proviant.model.dto.ProductDto;
import ru.shop.proviant.model.entity.Product;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "product.category.id", target = "categoryId")
    ProductDto toDto(Product product);

    List<ProductDto> listDto(List<Product> products);
}
