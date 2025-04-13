package com.github.user_service.userGameProfile.controller;

import com.github.user_service.userGameProfile.dto.UserGameProfileGetResponse;
import com.github.user_service.userGameProfile.dto.UserGameProfileRequest;
import com.github.user_service.userGameProfile.dto.UserGameProfileSaveResponse;
import com.github.user_service.userGameProfile.entity.Game;
import com.github.user_service.userGameProfile.service.UserGameProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<UserGameProfileSaveResponse> saveUserGameProfile(@RequestBody UserGameProfileRequest userGameProfileRequest, @PathVariable String username) {
        return new ResponseEntity<>(userGameProfileService.saveUserGameProfile(userGameProfileRequest, username), HttpStatus.CREATED);
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
    public ResponseEntity<String> deleteUserGameProfileByGame(@PathVariable String username, @PathVariable Game game){
        return new ResponseEntity<>(userGameProfileService.deleteUserGameProfileByGame(username, game), HttpStatus.OK);
    }

    @PutMapping("/{username}/game-profiles/{game}")
    public ResponseEntity<UserGameProfileGetResponse> updateUserGameProfile(@PathVariable String username, @PathVariable Game game,
                                                                            @RequestBody UserGameProfileRequest request){
        return new ResponseEntity<>(userGameProfileService.updateUserGameProfile(username, game, request), HttpStatus.OK);
    }

}
