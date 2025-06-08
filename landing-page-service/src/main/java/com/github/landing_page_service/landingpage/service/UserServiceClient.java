package com.github.landing_page_service.landingpage.service;

import com.github.landing_page_service.exception.UserCreationException;
import com.github.landing_page_service.exception.UserServiceUnavailableException;
import com.github.landing_page_service.landingpage.dto.CreateUserRequest;
import com.github.landing_page_service.landingpage.dto.LandingPageUserMeResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.*;

import java.util.Optional;

@Service
public class UserServiceClient {

    private final RestTemplate restTemplate;
    private final String apiGatewayUrl;

    public UserServiceClient(RestTemplate restTemplate, @Value("${services.api-gateway.url}")String apiGatewayUrl) {
        this.restTemplate = restTemplate;
        this.apiGatewayUrl = apiGatewayUrl;
    }

    public Optional<LandingPageUserMeResponse> getUser(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        HttpEntity<Void> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<LandingPageUserMeResponse> response = restTemplate.exchange(
                    apiGatewayUrl + "/api/users/me",
                    HttpMethod.GET,
                    entity,
                    LandingPageUserMeResponse.class
            );
            return Optional.ofNullable(response.getBody());

        } catch (HttpClientErrorException.NotFound e) {
            return Optional.empty();

        } catch (RestClientException ex) {
            throw new UserServiceUnavailableException("Błąd komunikacji z userservice", ex);
        }
    }

    public void createUser(String username, String keycloakUUID, String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);

        CreateUserRequest request = new CreateUserRequest(username, keycloakUUID);
        HttpEntity<CreateUserRequest> entity = new HttpEntity<>(request, headers);

        try {
            restTemplate.exchange(
                    apiGatewayUrl + "/api/users/" + username,
                    HttpMethod.POST,
                    entity,
                    LandingPageUserMeResponse.class
            );

        } catch (HttpClientErrorException | HttpServerErrorException ex) {
            throw new UserCreationException("Błąd tworzenia użytkownika: " +
                    ex.getStatusCode() + " - " + ex.getResponseBodyAsString(), ex);

        } catch (ResourceAccessException ex) {
            throw new UserServiceUnavailableException("Serwis użytkowników jest niedostępny", ex);
        }
    }
}