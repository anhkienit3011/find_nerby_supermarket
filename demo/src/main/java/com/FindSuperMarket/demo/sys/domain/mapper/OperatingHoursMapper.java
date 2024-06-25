package com.FindSuperMarket.demo.sys.domain.mapper;

import com.FindSuperMarket.demo.sys.domain.dto.OperatingHoursDTO;
import com.FindSuperMarket.demo.sys.domain.entity.OperatingHours;
import com.FindSuperMarket.demo.sys.domain.request.supermarket.OperatingHoursRequest;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OperatingHoursMapper {
    OperatingHoursDTO toDTO(OperatingHours operatingHours);

    List<OperatingHoursDTO> toDTOList(List<OperatingHours> operatingHours);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "supermarket", ignore = true)
    OperatingHours toEntity(OperatingHoursRequest request);

    List<OperatingHours> toEntityList(List<OperatingHoursRequest> requests);
}
