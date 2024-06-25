package com.FindSuperMarket.demo.sys.domain.mapper;

import com.FindSuperMarket.demo.sys.domain.dto.UserDTO;
import com.FindSuperMarket.demo.sys.domain.entity.User;
import com.FindSuperMarket.demo.sys.domain.request.user.UserRegistrationRequest;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "location", ignore = true)
    UserDTO toDTO(User user);

    List<UserDTO> toDTOList(List<User> users);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "passwordHash", ignore = true)
    @Mapping(target = "location", ignore = true)
    User toEntity(UserRegistrationRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "passwordHash", ignore = true)
    @Mapping(target = "location", ignore = true)
    void updateEntityFromRequest(UserRegistrationRequest request, @MappingTarget User user);
}