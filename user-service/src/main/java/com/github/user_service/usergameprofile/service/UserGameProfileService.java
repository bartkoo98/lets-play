package com.github.user_service.usergameprofile.service;

import com.github.user_service.exception.ResourceNotFoundException;
import com.github.user_service.user.entity.User;
import com.github.user_service.user.repository.UserRepository;
import com.github.user_service.usergameprofile.dto.UserGameProfileCreateRequest;
import com.github.user_service.usergameprofile.dto.UserGameProfileGetResponse;
import com.github.user_service.usergameprofile.dto.UserGameProfileSaveResponse;
import com.github.user_service.usergameprofile.dto.UserGameProfileUpdateResponse;
import com.github.user_service.usergameprofile.entity.Game;
import com.github.user_service.usergameprofile.entity.UserGameProfile;
import com.github.user_service.usergameprofile.repository.UserGameProfileRepository;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Set;

import static com.github.user_service.usergameprofile.dto.mapper.UserGameProfileMapper.*;

@Service
public class UserGameProfileService {

    private final UserGameProfileRepository userGameProfileRepository;
    private final UserRepository userRepository;

    public UserGameProfileService(UserGameProfileRepository userGameProfileRepository, UserRepository userRepository) {
        this.userGameProfileRepository = userGameProfileRepository;
        this.userRepository = userRepository;
    }

    public UserGameProfileSaveResponse saveUserGameProfile(UserGameProfileCreateRequest request, String username, Jwt jwt) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        String tokenUsername = jwt.getClaim("preferred_username");
        if (!Objects.equals(username, tokenUsername)) {
            throw new AccessDeniedException("You cannot create user game profile as: " + tokenUsername + "for the account of: " + username);
        }

        UserGameProfile profile = userGameProfileRequestToEntity(request);
        profile.setUser(user);

        userGameProfileRepository.save(profile);

        return mapToDtoSaveResponse(profile);
    }

    public UserGameProfileGetResponse getUserGameProfileByGame(String username, Game game) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        UserGameProfile profile = userGameProfileRepository.findByUserAndGame(user, game)
                .orElseThrow(() -> new ResourceNotFoundException("UserGameProfile", "game", game.toString()));

        return mapToDtoUserGameProfileGetResponse(profile);
    }

    public Set<UserGameProfileGetResponse> getAllUserGameProfiles(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        Set<UserGameProfile> profile = userGameProfileRepository.findAllGameProfilesByUser(user);

        return mapToDtoGetResponseSet(profile);
    }

    public String deleteUserGameProfileByGame(String username, Game game, Jwt jwt) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        String tokenUsername = jwt.getClaim("preferred_username");
        if (!Objects.equals(username, tokenUsername)) {
            throw new AccessDeniedException("You cannot delete user game profile as: " + tokenUsername + "for the account of: " + username);
        }

        UserGameProfile profile = userGameProfileRepository.findByUserAndGame(user, game)
                .orElseThrow(() -> new ResourceNotFoundException("UserGameProfile", "game", game.toString()));

        userGameProfileRepository.delete(profile);

        return "UserGameProfile of game: " + game.toString() + " has been deleted for user: " + user.getUsername();
    }

    public UserGameProfileUpdateResponse updateUserGameProfile(String username, Game game, UserGameProfileCreateRequest request, Jwt jwt) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        String tokenUsername = jwt.getClaim("preferred_username");
        if (!Objects.equals(username, tokenUsername)) {
            throw new AccessDeniedException("You cannot update user game profile as: " + tokenUsername + "for the account of: " + username);
        }

        UserGameProfile profile = userGameProfileRepository.findByUserAndGame(user, game)
                .orElseThrow(() -> new ResourceNotFoundException("UserGameProfile", "game", game.toString()));

        mapToEntityUserGameProfileUpdate(profile, request);
        userGameProfileRepository.save(profile);

        return mapToDtoUserGameProfileUpdateResponse(profile);
    }

}
