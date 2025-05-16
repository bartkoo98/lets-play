package com.github.user_service.landingpage.service;

import com.github.user_service.landingpage.dto.LandingPageResponse;
import com.github.user_service.user.entity.User;
import com.github.user_service.user.service.UserService;
import com.github.user_service.usergameprofile.dto.UserGameProfileGetResponse;
import com.github.user_service.usergameprofile.service.UserGameProfileService;
import com.github.user_service.usersettings.dto.UserSettingsGetResponse;
import com.github.user_service.usersettings.service.UserSettingsService;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.util.Set;

import static com.github.user_service.user.dto.mapper.UserMapper.mapEntityToDto;

@Service
public class LandingPageService {

    private final UserService userService;
    private final UserGameProfileService userGameProfileService;
    private final UserSettingsService userSettingsService;

    public LandingPageService(UserService userService,
                              UserGameProfileService userGameProfileService,
                              UserSettingsService userSettingsService) {
        this.userService = userService;
        this.userGameProfileService = userGameProfileService;
        this.userSettingsService = userSettingsService;
    }

    public LandingPageResponse getLandingPageData(Jwt jwt) {
        String keycloakUUID = jwt.getClaim("sub");
        String username = jwt.getClaim("preferred_username");

        User user = userService.findOrCreateByKeycloakUUID(keycloakUUID, username);
        Set<UserGameProfileGetResponse> profiles = userGameProfileService.getAllUserGameProfiles(user.getUsername());
        UserSettingsGetResponse settings = userSettingsService.getUserSettings(username, jwt);

        return LandingPageResponse
                .builder()
                .userResponse(mapEntityToDto(user))
                .userSettingsGetResponse(settings)
                .userGameProfileGetResponse(profiles)
                .build();
    }
}
