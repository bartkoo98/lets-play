package com.github.landing_page_service.landingpage.service;

import com.github.landing_page_service.exception.UserCreationException;
import com.github.landing_page_service.landingpage.dto.LandingPageUserMeResponse;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LandingPageService {

    private final UserServiceClient userServiceClient;

    public LandingPageService(UserServiceClient userServiceClient) {
        this.userServiceClient = userServiceClient;
    }

    public LandingPageUserMeResponse buildLandingPage(Jwt jwt) {
        String keycloakUUID = jwt.getClaim("sub");
        String username = jwt.getClaim("preferred_username");
        String token = jwt.getTokenValue();

        Optional<LandingPageUserMeResponse> userData = userServiceClient.getUser(token);

        if (userData.isPresent()) {
            return userData.get();
        }

        userServiceClient.createUser(username, keycloakUUID, token);

        return userServiceClient.getUser(token)
                .orElseThrow(() -> new UserCreationException("Użytkownik nie został utworzony pomyślnie."));
    }

}