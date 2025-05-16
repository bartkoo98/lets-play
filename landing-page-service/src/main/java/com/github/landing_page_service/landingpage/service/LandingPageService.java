package com.github.landing_page_service.landingpage.service;

import com.github.landing_page_service.landingpage.dto.LandingPageResponse;
import com.github.landing_page_service.landingpage.dto.LandingPageUserResponse;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LandingPageService {

    private final UserClient userClient;
    private final UserCreator userCreator;

    public LandingPageService(UserClient userClient, UserCreator userCreator) {
        this.userClient = userClient;
        this.userCreator = userCreator;
    }

    public LandingPageResponse buildLandingPage(Jwt jwt){
        String keycloakUUID = jwt.getClaim("sub");
        String username = jwt.getClaim("preferred_username");
        String token = jwt.getTokenValue();

        Optional<LandingPageUserResponse> user = userClient.getUserByUsername(username, token);

        if(user.isEmpty()) {
            user = Optional.of(userCreator.createUser(username, keycloakUUID, token));
        }

        return new LandingPageResponse(user.get());
    }

}
