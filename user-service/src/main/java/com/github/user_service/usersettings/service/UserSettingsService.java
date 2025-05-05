package com.github.user_service.usersettings.service;

import com.github.user_service.exception.ResourceNotFoundException;
import com.github.user_service.user.entity.User;
import com.github.user_service.user.repository.UserRepository;
import com.github.user_service.usersettings.dto.UserSettingsGetResponse;
import com.github.user_service.usersettings.dto.UserSettingsUpdateRequest;
import com.github.user_service.usersettings.dto.UserSettingsUpdateResponse;
import com.github.user_service.usersettings.entity.UserSettings;
import com.github.user_service.usersettings.repository.UserSettingsRepository;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.github.user_service.usersettings.dto.mapper.UserSettingsMapper.mapToDtoUserSettingsUpdateResponse;
import static com.github.user_service.usersettings.dto.mapper.UserSettingsMapper.mapToEntityUserSettings;

@Service
public class UserSettingsService {

    private final UserSettingsRepository userSettingsRepository;
    private final UserRepository userRepository;

    public UserSettingsService(UserSettingsRepository userSettingsRepository, UserRepository userRepository) {
        this.userSettingsRepository = userSettingsRepository;
        this.userRepository = userRepository;
    }

    public UserSettingsUpdateResponse updateUserSettings(String username, UserSettingsUpdateRequest request, Jwt jwt) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        String tokenUsername = jwt.getClaim("preferred_username");
        if (!Objects.equals(username, tokenUsername)) {
            throw new AccessDeniedException("You cannot update user settings as: " + tokenUsername + "for the account of: " + username);
        }

        UserSettings settings = userSettingsRepository.findByUser(user).orElseThrow(() -> new ResourceNotFoundException("UserSetting", "user", user.getUsername()));

        mapToEntityUserSettings(settings, request);
        userSettingsRepository.save(settings);

        return mapToDtoUserSettingsUpdateResponse(settings);

    }

    public UserSettingsGetResponse getUserSettings(String username, Jwt jwt) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        String tokenUsername = jwt.getClaim("preferred_username");
        if (!Objects.equals(username, tokenUsername)) {
            throw new AccessDeniedException("You cannot get user settings as: " + tokenUsername + "for the account of: " + username);
        }

        UserSettings settings = userSettingsRepository.findByUser(user).orElseThrow(() -> new ResourceNotFoundException("UserSetting", "user", user.getUsername()));

        return UserSettingsGetResponse.builder()
                .theme(settings.getTheme())
                .notification(settings.getNotification())
                .language(settings.getLanguage()).build();

    }
}
