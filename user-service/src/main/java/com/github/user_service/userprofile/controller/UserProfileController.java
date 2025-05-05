package com.github.user_service.userprofile.controller;

import com.github.user_service.userprofile.dto.UserProfileRequestDto;
import com.github.user_service.userprofile.dto.UserProfileResponseDto;
import com.github.user_service.userprofile.service.UserProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserProfileController {

    private final UserProfileService userProfileService;

    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @PostMapping("/{username}/profile")
    public ResponseEntity<Void> createUserProfile(
            @PathVariable String username,
            @RequestBody UserProfileRequestDto userProfileRequestDto,
            @AuthenticationPrincipal Jwt jwt) {

        userProfileService.createUserProfile(userProfileRequestDto, username, jwt);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{username}/profile")
    public ResponseEntity<Void> updateUserProfile(
            @PathVariable String username,
            @RequestBody UserProfileRequestDto userProfileRequestDto,
            @AuthenticationPrincipal Jwt jwt) {

        userProfileService.updateUserProfile(userProfileRequestDto, username, jwt);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{username}/profile")
    public ResponseEntity<UserProfileResponseDto> getUserProfile(
            @PathVariable String username) {

        UserProfileResponseDto userProfile = userProfileService.getUserProfile(username);

        return new ResponseEntity<>(userProfile, HttpStatus.OK);
    }
}
