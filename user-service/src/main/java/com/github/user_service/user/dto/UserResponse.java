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
public class UserResponse {
    //user
    private String username;
    //userprofile
    private String sex;
    private Integer age;
    private String avatar;
    private String description;
    private String city;
    private Set<Language> userLanguages;
    //usergameprofile
    private Set<UserGameProfileMeResponse> userGameProfiles;
}