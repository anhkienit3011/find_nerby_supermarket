package com.FindSuperMarket.demo.sys.domain.mapper;

import com.FindSuperMarket.demo.sys.domain.dto.SupermarketDTO;
import com.FindSuperMarket.demo.sys.domain.entity.Category;
import com.FindSuperMarket.demo.sys.domain.entity.Supermarket;
import com.FindSuperMarket.demo.sys.domain.request.supermarket.CreateSupermarketRequest;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class, OperatingHoursMapper.class})
public interface SupermarketMapper {
    @Mapping(target = "categories", source = "categories")
    @Mapping(target = "operatingHours", source = "operatingHours")
    SupermarketDTO toDTO(Supermarket supermarket);

    List<SupermarketDTO> toDTOList(List<Supermarket> supermarkets);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "categories", ignore = true)
    @Mapping(target = "operatingHours", ignore = true)
    Supermarket toEntity(CreateSupermarketRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "categories", ignore = true)
    @Mapping(target = "operatingHours", ignore = true)
    void updateEntityFromRequest(CreateSupermarketRequest request, @MappingTarget Supermarket supermarket);

    default String mapCategoryToName(Category category) {
        return category.getName();
    }
}
