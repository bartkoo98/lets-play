package com.github.user_service.usergameprofile.controller;

import com.github.user_service.usergameprofile.dto.UserGameProfileGetResponse;
import com.github.user_service.usergameprofile.dto.UserGameProfileCreateRequest;
import com.github.user_service.usergameprofile.dto.UserGameProfileSaveResponse;
import com.github.user_service.usergameprofile.dto.UserGameProfileUpdateResponse;
import com.github.user_service.usergameprofile.entity.Game;
import com.github.user_service.usergameprofile.service.UserGameProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@RequestMapping("/api/users")
public class UserGameProfileController {

    private final UserGameProfileService userGameProfileService;

    public UserGameProfileController(UserGameProfileService userGameProfileService) {
        this.userGameProfileService = userGameProfileService;
    }

    @PostMapping("{username}/game-profiles")
    public ResponseEntity<UserGameProfileSaveResponse> saveUserGameProfile(@RequestBody UserGameProfileCreateRequest userGameProfileCreateRequest, @PathVariable String username,
                                                                           @AuthenticationPrincipal Jwt jwt) {
        return new ResponseEntity<>(userGameProfileService.saveUserGameProfile(userGameProfileCreateRequest, username, jwt), HttpStatus.CREATED);
    }

    @GetMapping("/{username}/game-profiles/{game}")
    public ResponseEntity<UserGameProfileGetResponse> getUserGameProfileByGame(@PathVariable String username, @PathVariable Game game){
        return new ResponseEntity<>(userGameProfileService.getUserGameProfileByGame(username, game), HttpStatus.OK);
    }

    @GetMapping("/{username}/game-profiles")
    public ResponseEntity<Set<UserGameProfileGetResponse>> getAllUserGameProfiles(@PathVariable String username){
        return new ResponseEntity<>(userGameProfileService.getAllUserGameProfiles(username), HttpStatus.OK);
    }

    @DeleteMapping("/{username}/game-profiles/{game}")
    public ResponseEntity<String> deleteUserGameProfileByGame(@PathVariable String username, @PathVariable Game game,
                                                              @AuthenticationPrincipal Jwt jwt){

        return new ResponseEntity<>(userGameProfileService.deleteUserGameProfileByGame(username, game, jwt), HttpStatus.OK);
    }

    @PutMapping("/{username}/game-profiles/{game}")
    public ResponseEntity<UserGameProfileUpdateResponse> updateUserGameProfile(@PathVariable String username, @PathVariable Game game,
                                                                               @RequestBody UserGameProfileCreateRequest request,
                                                                               @AuthenticationPrincipal Jwt jwt){
        return new ResponseEntity<>(userGameProfileService.updateUserGameProfile(username, game, request, jwt), HttpStatus.OK);
    }

}
