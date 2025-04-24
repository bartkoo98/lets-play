package com.github.user_service.usersettings.controller;


import com.github.user_service.usersettings.dto.UserSettingsGetResponse;
import com.github.user_service.usersettings.dto.UserSettingsUpdateRequest;
import com.github.user_service.usersettings.dto.UserSettingsUpdateResponse;
import com.github.user_service.usersettings.service.UserSettingsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
public class UserSettingsController {

    private final UserSettingsService userSettingsService;

    public UserSettingsController(UserSettingsService userSettingsService) {
        this.userSettingsService = userSettingsService;
    }

    @PutMapping("/{username}/settings")
    public ResponseEntity<UserSettingsUpdateResponse> updateUserSettings(@PathVariable String username,
                                                                         @RequestBody UserSettingsUpdateRequest request,
                                                                         @AuthenticationPrincipal Jwt jwt){
        return new ResponseEntity<UserSettingsUpdateResponse>(userSettingsService.updateUserSettings(username, request, jwt), HttpStatus.OK);
    }

    @GetMapping("/{username}/settings")
    public ResponseEntity<UserSettingsGetResponse> getUserSettings (@PathVariable String username, @AuthenticationPrincipal Jwt jwt){
        return new ResponseEntity<UserSettingsGetResponse>(userSettingsService.getUserSettings(username, jwt), HttpStatus.OK);
    }


}
