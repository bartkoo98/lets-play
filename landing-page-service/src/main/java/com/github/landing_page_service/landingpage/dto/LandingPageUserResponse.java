package com.github.landing_page_service.landingpage.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class LandingPageUserResponse {
    private String username;
    private String keycloakUUID;
    private boolean verified;
}
