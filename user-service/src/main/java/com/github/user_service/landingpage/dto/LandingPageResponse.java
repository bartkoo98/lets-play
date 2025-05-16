package com.github.user_service.landingpage.dto;


import com.github.user_service.user.dto.UserResponse;
import com.github.user_service.usergameprofile.dto.UserGameProfileGetResponse;
import com.github.user_service.usersettings.dto.UserSettingsGetResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LandingPageResponse {
    private UserResponse userResponse;
    private Set<UserGameProfileGetResponse> userGameProfileGetResponse;
    private UserSettingsGetResponse userSettingsGetResponse;
}
