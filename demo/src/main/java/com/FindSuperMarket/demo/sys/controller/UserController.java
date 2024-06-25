package com.FindSuperMarket.demo.sys.controller;

import com.FindSuperMarket.demo.sys.domain.dto.UserDTO;
import com.FindSuperMarket.demo.sys.domain.request.user.UpdateUserLocationRequest;
import com.FindSuperMarket.demo.sys.domain.request.user.UserRegistrationRequest;
import com.FindSuperMarket.demo.sys.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserRegistrationRequest request) {
        UserDTO userDTO = userService.registerUser(request);
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        UserDTO userDTO = userService.getUserById(id);
        return ResponseEntity.ok(userDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserRegistrationRequest request) {
        UserDTO userDTO = userService.updateUser(id, request);
        return ResponseEntity.ok(userDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/location")
    public ResponseEntity<Void> updateUserLocation(@PathVariable Long id, @RequestBody UpdateUserLocationRequest request) {
        userService.updateUserLocation(id, request);
        return ResponseEntity.noContent().build();
    }
}
