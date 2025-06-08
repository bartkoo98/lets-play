package com.github.user_service.user.service;

import com.github.user_service.exception.ResourceNotFoundException;
import com.github.user_service.user.dto.UserMeResponse;
import com.github.user_service.user.dto.UserResponse;
import com.github.user_service.user.entity.User;
import com.github.user_service.user.repository.UserRepository;
import com.github.user_service.usergameprofile.repository.UserGameProfileRepository;
import com.github.user_service.userprofile.repository.UserProfileRepository;
import com.github.user_service.usersettings.entity.UserSettings;
import com.github.user_service.usersettings.repository.UserSettingsRepository;
import com.github.user_service.utils.Language;
import jakarta.transaction.Transactional;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import static com.github.user_service.user.dto.mapper.UserMapper.toUserMeResponse;
import static com.github.user_service.user.dto.mapper.UserMapper.toUserResponse;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserSettingsRepository userSettingsRepository;
    private final UserProfileRepository userProfileRepository;
    private final UserGameProfileRepository userGameProfileRepository;

    public UserService(UserRepository userRepository,
                       UserSettingsRepository userSettingsRepository,
                       UserProfileRepository userProfileRepository,
                       UserGameProfileRepository userGameProfileRepository) {
        this.userRepository = userRepository;
        this.userSettingsRepository = userSettingsRepository;
        this.userProfileRepository = userProfileRepository;
        this.userGameProfileRepository = userGameProfileRepository;
    }

    public UserResponse getUserByUsername(String username){
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User ", "username", username));

        return toUserResponse(user);
    }

    public UserMeResponse getUserByKeycloakUUID(Jwt jwt){
        String keycloakUUID = jwt.getClaim("sub");

        User user = userRepository.findWithDetailsByKeycloakUUID(keycloakUUID)
                .orElseThrow(() -> new ResourceNotFoundException("User", "uuid", keycloakUUID));

        return toUserMeResponse(user);
    }

    @Transactional
    public void createUser(Jwt jwt){
        String keycloakUUID = jwt.getClaim("sub");
        String username = jwt.getClaim("preferred_username");

        User user = User.builder()
                .username(username)
                .keycloakUUID(keycloakUUID)
                .isProfileCompleted(false)
                .build();

        UserSettings settings = UserSettings.builder()
                .theme(false)
                .notification(true)
                .language(Language.ENG)
                .user(user)
                .build();

        user.setUserSettings(settings);
        userRepository.save(user);
    }

}