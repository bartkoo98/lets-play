package com.github.landing_page_service.landingpage.controller;

import com.github.landing_page_service.landingpage.dto.LandingPageUserMeResponse;
import com.github.landing_page_service.landingpage.service.LandingPageService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/landing")
public class LandingPageController {

    private final LandingPageService landingPageService;

    public LandingPageController(LandingPageService landingPageService) {
        this.landingPageService = landingPageService;
    }

    @GetMapping
    public ResponseEntity<LandingPageUserMeResponse> buildLandingPage(@AuthenticationPrincipal Jwt jwt) {
        LandingPageUserMeResponse response = landingPageService.buildLandingPage(jwt);
        return ResponseEntity.ok(response);
    }
}