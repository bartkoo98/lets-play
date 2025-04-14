package com.github.user_service.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/users")
public class UserProfileController {

    private final UserProfileService userProfileService;

    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @PostMapping
    public ResponseEntity<UserProfileDto> createUserProfile(
            @PathVariable String username,
            @RequestBody UserProfileCreateDto userProfileCreateDto) {

        UserProfileDto createdProfile = userProfileService.createUserProfile(userProfileCreateDto, username);
        return new ResponseEntity<>(createdProfile, HttpStatus.CREATED);
    }
}
