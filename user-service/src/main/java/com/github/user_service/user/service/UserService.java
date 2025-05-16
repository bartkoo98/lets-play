package com.github.user_service.user.service;

import com.github.user_service.user.entity.User;
import com.github.user_service.user.repository.UserRepository;
import com.github.user_service.userprofile.entity.UserProfile;
import com.github.user_service.userprofile.repository.UserProfileRepository;
import com.github.user_service.usersettings.entity.UserSettings;
import com.github.user_service.usersettings.repository.UserSettingsRepository;
import com.github.user_service.utils.City;
import com.github.user_service.utils.Language;
import com.github.user_service.utils.Sex;
import org.springframework.stereotype.Service;


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

    public User findOrCreateByKeycloakUUID(String keycloakUUID, String username) {
        return userRepository.findByKeycloakUUID(keycloakUUID)
                .orElseGet(() -> {
                    User newUser = new User();
                    newUser.setKeycloakUUID(keycloakUUID);
                    newUser.setUsername(username);
                    User savedUser = userRepository.save(newUser);

                    UserProfile userProfile = UserProfile.
                            builder()
                            .user(newUser)
                            .sex(Sex.NONE)
                            .age(65)
                            .avatar("null")
                            .description("lorem ipsum")
                            .city(City.WARSZAWA).build();
                    userProfileRepository.save(userProfile);

                    UserSettings settings = UserSettings
                            .builder()
                            .user(newUser)
                            .theme(false)
                            .notification(true)
                            .language(Language.ENG)
                            .build();
                    userSettingsRepository.save(settings);
                    return savedUser;
                });
    }
}

