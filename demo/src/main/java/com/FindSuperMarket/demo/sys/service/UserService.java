package com.FindSuperMarket.demo.sys.service;

import com.FindSuperMarket.demo.sys.domain.dto.UserDTO;
import com.FindSuperMarket.demo.sys.domain.request.user.UpdateUserLocationRequest;
import com.FindSuperMarket.demo.sys.domain.request.user.UserRegistrationRequest;

public interface UserService {
    UserDTO registerUser(UserRegistrationRequest request);
    UserDTO getUserById(Long id);
    UserDTO updateUser(Long id, UserRegistrationRequest request);
    void deleteUser(Long id);
    void updateUserLocation(Long userId, UpdateUserLocationRequest request);
}
