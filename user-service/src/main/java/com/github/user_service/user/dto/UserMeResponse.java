package com.github.user_service.user.dto;

import com.github.user_service.usergameprofile.dto.UserGameProfileMeResponse;
import com.github.user_service.utils.Language;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UserMeResponse {
    //user
    private boolean isProfileCompleted;
    //userprofile
    private String sex;
    private Integer age;
    private String avatar;
    private String description;
    private String city;
    private Set<Language> userLanguages;
    //usersettings
    private Boolean theme;
    private Boolean notification;
    private String appLanguage;
    //usergameprofile
    private Set<UserGameProfileMeResponse> userGameProfiles;
}