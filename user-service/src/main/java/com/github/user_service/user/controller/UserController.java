package com.github.user_service.user.controller;

import com.github.user_service.user.dto.UserMeResponse;
import com.github.user_service.user.dto.UserResponse;
import com.github.user_service.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserResponse> getUserByUsername(@PathVariable String username, @AuthenticationPrincipal Jwt jwt){
        return new ResponseEntity<>(userService.getUserByUsername(username), HttpStatus.OK);
    }

    @GetMapping("/me")
    public ResponseEntity<UserMeResponse> getUser(@AuthenticationPrincipal Jwt jwt){
        return new ResponseEntity<>(userService.getUserByKeycloakUUID(jwt), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@AuthenticationPrincipal Jwt jwt){
        userService.createUser(jwt);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}