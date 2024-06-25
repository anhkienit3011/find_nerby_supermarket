package com.FindSuperMarket.demo.sys.domain.mapper;

import com.FindSuperMarket.demo.sys.domain.dto.UserLocationDTO;
import com.FindSuperMarket.demo.sys.domain.entity.UserLocation;
import com.FindSuperMarket.demo.sys.domain.request.user.UpdateUserLocationRequest;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UserLocationMapper {
    @Mapping(source = "user.id", target = "userId")
    UserLocationDTO toDTO(UserLocation userLocation);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    UserLocation toEntity(UpdateUserLocationRequest request);
}
