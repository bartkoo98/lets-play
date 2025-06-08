package com.github.landing_page_service.landingpage.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class LandingPageUserMeResponse {
    //user
    private boolean isProfileCompleted;
    //userprofile
    private String sex;
    private Integer age;
    private String avatar;
    private String description;
    private String city;
    private Set<String> userLanguages;
    //usersettings
    private Boolean theme;
    private Boolean notification;
    private String appLanguage;
    //usergameprofile
    private Set<UserGameProfileDto> userGameProfiles;
}