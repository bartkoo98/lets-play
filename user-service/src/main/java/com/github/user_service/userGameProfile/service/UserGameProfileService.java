package com.github.user_service.userGameProfile.service;

import com.github.user_service.user.entity.User;
import com.github.user_service.user.repository.UserRepository;
import com.github.user_service.userGameProfile.dto.UserGameProfileGetResponse;
import com.github.user_service.userGameProfile.dto.UserGameProfileRequest;
import com.github.user_service.userGameProfile.dto.UserGameProfileSaveResponse;
import com.github.user_service.userGameProfile.entity.Game;
import com.github.user_service.userGameProfile.entity.UserGameProfile;
import com.github.user_service.userGameProfile.exception.ResourceNotFoundException;
import com.github.user_service.userGameProfile.repository.UserGameProfileRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

import static com.github.user_service.userGameProfile.dto.mapper.UserGameProfileMapper.*;

@Service
public class UserGameProfileService {

    private final UserGameProfileRepository userGameProfileRepository;
    private final UserRepository userRepository;

    public UserGameProfileService(UserGameProfileRepository userGameProfileRepository, UserRepository userRepository) {
        this.userGameProfileRepository = userGameProfileRepository;
        this.userRepository = userRepository;
    }

    public UserGameProfileSaveResponse saveUserGameProfile(UserGameProfileRequest request, String username) {

        User user = userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        UserGameProfile profile = userGameProfileRequestToEntity(request);
        profile.setUser(user);

        userGameProfileRepository.save(profile);
        return toDtoSaveResponse(profile);

    }

    public UserGameProfileGetResponse getUserGameProfileByGame(String username, Game game){
        User user = userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        UserGameProfile profile = userGameProfileRepository.findByUserAndGame(user, game)
                .orElseThrow(() -> new ResourceNotFoundException("UserGameProfile", "game", game.toString()));

        return toDtoGetUserProfileResponse(profile);
    }

    public Set<UserGameProfileGetResponse> getAllUserGameProfiles(String username){
        User user = userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        Set<UserGameProfile> profile = userGameProfileRepository.findAllProfilesByUser(user);

        return toDtoGetResponseSet(profile);

    }

    public String deleteUserGameProfileByGame (String username, Game game){
        User user = userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
        UserGameProfile profile = userGameProfileRepository.findByUserAndGame(user, game)
                .orElseThrow(() -> new ResourceNotFoundException("UserGameProfile", "game", game.toString()));
        userGameProfileRepository.delete(profile);

        return "UserGameProfile of game: " + game.toString() + " has been deleted for user: " + user.getUsername();
    }

    public UserGameProfileGetResponse updateUserGameProfile(String username, Game game, UserGameProfileRequest request){

        User user = userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
        UserGameProfile profile = userGameProfileRepository.findByUserAndGame(user, game)
                .orElseThrow(() -> new ResourceNotFoundException("UserGameProfile", "game", game.toString()));

        toEntityUserGameProfileUpdate(profile, request);
        userGameProfileRepository.save(profile);

        return toDtoGetUserProfileResponse(profile);

    }

}
