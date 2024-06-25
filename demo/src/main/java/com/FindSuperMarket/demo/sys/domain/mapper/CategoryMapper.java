package com.FindSuperMarket.demo.sys.domain.mapper;

import com.FindSuperMarket.demo.sys.domain.dto.CategoryDTO;
import com.FindSuperMarket.demo.sys.domain.entity.Category;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDTO toDTO(Category category);

    List<CategoryDTO> toDTOList(List<Category> categories);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "supermarkets", ignore = true)
    Category toEntity(String name);
}
