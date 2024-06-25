package com.FindSuperMarket.demo.sys.service.imp;

import com.FindSuperMarket.demo.exception.DuplicateResourceException;
import com.FindSuperMarket.demo.exception.ResourceNotFoundException;
import com.FindSuperMarket.demo.sys.domain.dto.UserDTO;
import com.FindSuperMarket.demo.sys.domain.entity.User;
import com.FindSuperMarket.demo.sys.domain.entity.UserLocation;
import com.FindSuperMarket.demo.sys.domain.mapper.UserMapper;
import com.FindSuperMarket.demo.sys.domain.request.user.UpdateUserLocationRequest;
import com.FindSuperMarket.demo.sys.domain.request.user.UserRegistrationRequest;
import com.FindSuperMarket.demo.sys.repository.UserLocationRepository;
import com.FindSuperMarket.demo.sys.repository.UserRepository;
import com.FindSuperMarket.demo.sys.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserLocationRepository userLocationRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    @Override
    public UserDTO registerUser(UserRegistrationRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new DuplicateResourceException("Username already exists");
        }
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateResourceException("Email already exists");
        }
        User user = userMapper.toEntity(request);
        user.setPasswordHash(passwordEncoder.encode(request.getPassword()));
        user = userRepository.save(user);
        return userMapper.toDTO(user);
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return userMapper.toDTO(user);
    }

    @Override
    public UserDTO updateUser(Long id, UserRegistrationRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        userMapper.updateEntityFromRequest(request, user);
        if (request.getPassword() != null) {
            user.setPasswordHash(passwordEncoder.encode(request.getPassword()));
        }
        user = userRepository.save(user);
        return userMapper.toDTO(user);
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User not found");
        }
        userRepository.deleteById(id);
    }

    @Override
    public void updateUserLocation(Long userId, UpdateUserLocationRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        UserLocation location = user.getLocation();
        if (location == null) {
            location = new UserLocation();
            location.setUser(user);
        }
        location.setLatitude(request.getLatitude());
        location.setLongitude(request.getLongitude());
        userLocationRepository.save(location);
    }
}
