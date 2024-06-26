package com.FindSuperMarket.demo.sys.domain.mapper;

import com.FindSuperMarket.demo.sys.domain.dto.UserDTO;
import com.FindSuperMarket.demo.sys.domain.dto.UserLocationDTO;
import com.FindSuperMarket.demo.sys.domain.entity.User;
import com.FindSuperMarket.demo.sys.domain.entity.UserLocation;
import com.FindSuperMarket.demo.sys.domain.request.user.UserRegistrationRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "passwordHash", ignore = true)
    @Mapping(target = "location", ignore = true)
    User toEntity(UserRegistrationRequest request);

    UserDTO toDTO(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "passwordHash", ignore = true)
    @Mapping(target = "location", ignore = true)
    void updateEntityFromRequest(UserRegistrationRequest request, @MappingTarget User user);

    @Mapping(source = "user.id", target = "userId")
    UserLocationDTO toDTO(UserLocation userLocation);
}