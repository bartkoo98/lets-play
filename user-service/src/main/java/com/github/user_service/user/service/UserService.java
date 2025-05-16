package com.github.user_service.user.service;

import com.github.user_service.exception.ResourceNotFoundException;
import com.github.user_service.user.dto.UserResponse;
import com.github.user_service.user.entity.User;
import com.github.user_service.user.repository.UserRepository;
import com.github.user_service.userprofile.entity.UserProfile;
import com.github.user_service.userprofile.repository.UserProfileRepository;
import com.github.user_service.usersettings.entity.UserSettings;
import com.github.user_service.usersettings.repository.UserSettingsRepository;
import com.github.user_service.utils.City;
import com.github.user_service.utils.Language;
import com.github.user_service.utils.Sex;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.util.Set;

import static com.github.user_service.user.dto.mapper.UserMapper.mapEntityToDto;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserSettingsRepository userSettingsRepository;
    private final UserProfileRepository userProfileRepository;

    public UserService(UserRepository userRepository,
                       UserSettingsRepository userSettingsRepository,
                       UserProfileRepository userProfileRepository) {
        this.userRepository = userRepository;
        this.userSettingsRepository = userSettingsRepository;
        this.userProfileRepository = userProfileRepository;
    }

    public UserResponse getUserByKeycloakUUID(Jwt jwt){
        String keycloakUUID = jwt.getClaim("sub");
        User user = userRepository.findByKeycloakUUID(keycloakUUID)
                .orElseThrow(() -> new ResourceNotFoundException("User", keycloakUUID, "uuid"));
        return UserResponse.builder()
                .keycloakUUID(user.getKeycloakUUID())
                .username(user.getUsername())
                .verified(user.isVerified())
                .build();
    }

    public UserResponse createUser(String username, Jwt jwt){
        String keycloakUUID = jwt.getClaim("sub");

        User user = User.builder()
                .username(username)
                .keycloakUUID(keycloakUUID)
                .verified(false)
                .build();

        UserSettings settings = UserSettings.builder()
                .theme(false)
                .notification(true)
                .language(Language.ENG)
                .user(user)
                .build();

        UserProfile profile = UserProfile.builder()
                .sex(Sex.NONE)
                .age(69)
                .avatar("avater.png")
                .description("lorem ipsum")
                .city(City.LUKOW)
                .userLanguages(Set.of(Language.ENG))
                .user(user)
                .build();

        userRepository.save(user);
        userProfileRepository.save(profile);
        userSettingsRepository.save(settings);

        return mapEntityToDto(user);
    }

}

