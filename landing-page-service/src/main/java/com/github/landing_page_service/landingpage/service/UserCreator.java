package com.github.landing_page_service.landingpage.service;

import com.github.landing_page_service.landingpage.dto.CreateUserRequest;
import com.github.landing_page_service.landingpage.dto.LandingPageUserResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserCreator {

    private final RestTemplate restTemplate;

    public UserCreator(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${services.api-gateway.url}")
    private String apiGatewayUrl;

    public LandingPageUserResponse createUser(String username, String keycloakUUID, String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);

        CreateUserRequest request = new CreateUserRequest(username, keycloakUUID);
        HttpEntity<CreateUserRequest> entity = new HttpEntity<>(request, headers);

        ResponseEntity<LandingPageUserResponse> response = restTemplate.exchange(
                apiGatewayUrl + "/api/users/" + username,
                HttpMethod.POST,
                entity,
                LandingPageUserResponse.class
        );

        return response.getBody();
    }
}

