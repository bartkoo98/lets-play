package com.github.landing_page_service.landingpage.service;

import com.github.landing_page_service.landingpage.dto.LandingPageUserResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class UserClient {

    private final RestTemplate restTemplate;

    @Value("${services.api-gateway.url}")
    private String apiGatewayUrl;

    public UserClient (RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Optional<LandingPageUserResponse> getUserByUsername(String username, String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<LandingPageUserResponse> response = restTemplate.exchange(
                    apiGatewayUrl + "/api/users" + username,
                    HttpMethod.GET,
                    entity,
                    LandingPageUserResponse.class
            );
            return Optional.ofNullable(response.getBody());
        } catch (HttpClientErrorException.NotFound e){
            return Optional.empty();
        }
    }
}
