package com.github.landing_page_service.landingpage.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UserGameProfileDto {
    private String game;
    private String elo;
    private String approach;
    private String role;
    private String peak;
    private String accountLink;
}