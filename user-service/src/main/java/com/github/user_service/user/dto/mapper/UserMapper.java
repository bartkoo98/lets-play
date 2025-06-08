package com.github.user_service.user.dto.mapper;

import com.github.user_service.user.dto.UserMeResponse;
import com.github.user_service.user.dto.UserResponse;
import com.github.user_service.user.entity.User;
import com.github.user_service.usergameprofile.dto.UserGameProfileMeResponse;
import com.github.user_service.usergameprofile.entity.UserGameProfile;
import com.github.user_service.userprofile.entity.UserProfile;
import com.github.user_service.usersettings.entity.UserSettings;

import java.util.Set;
import java.util.stream.Collectors;

public class UserMapper {

    public static UserResponse toUserResponse(User user){
        UserProfile profile = user.getUserProfile();
        Set<UserGameProfile> gameProfiles = user.getUserGameProfiles();

        Set<UserGameProfileMeResponse> gameProfileDtos = gameProfiles.stream()
                .map(gp -> new UserGameProfileMeResponse(gp.getGame().toString(), gp.getElo(), gp.getApproach(), gp.getRole(),
                        gp.getPeak(), gp.getAccountLink()))
                .collect(Collectors.toSet());

        return UserResponse
                .builder()
                .username(user.getUsername())
                .sex(profile.getSex().toString())
                .age(profile.getAge())
                .avatar(profile.getAvatar())
                .description(profile.getDescription())
                .city(profile.getCity().toString())
                .userLanguages(profile.getUserLanguages())
                .userGameProfiles(gameProfileDtos)
                .build();
    }

    public static UserMeResponse toUserMeResponse(User user) {
        UserProfile profile = user.getUserProfile();
        UserSettings settings = user.getUserSettings();
        Set<UserGameProfile> gameProfiles = user.getUserGameProfiles();

        Set<UserGameProfileMeResponse> gameProfileDtos = gameProfiles.stream()
                .map(gp -> new UserGameProfileMeResponse(gp.getGame().toString(), gp.getElo(), gp.getApproach(), gp.getRole(),
                        gp.getPeak(), gp.getAccountLink()))
                .collect(Collectors.toSet());

        return UserMeResponse
                .builder()
                .isProfileCompleted(user.isProfileCompleted())
                .sex(profile.getSex().toString())
                .age(profile.getAge())
                .avatar(profile.getAvatar())
                .description(profile.getDescription())
                .city(profile.getCity().toString())
                .userLanguages(profile.getUserLanguages())
                .theme(settings.getTheme())
                .notification(settings.getNotification())
                .appLanguage(settings.getLanguage().toString())
                .userGameProfiles(gameProfileDtos)
                .build();
    }

}