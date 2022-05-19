package ru.shop.proviant.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.shop.proviant.model.dto.CategoryDto;
import ru.shop.proviant.model.entity.Category;

import java.util.List;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    @Mapping(source = "nameEnglish", target = "nameEnglish")
    CategoryDto toDto(Category category);

    List<CategoryDto> toListDto(List<Category> categories);
}
