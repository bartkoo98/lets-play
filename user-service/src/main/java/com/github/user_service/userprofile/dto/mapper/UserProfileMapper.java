package com.github.user_service.userprofile.dto.mapper;

import com.github.user_service.user.entity.User;
import com.github.user_service.userprofile.dto.UserProfileRequestDto;
import com.github.user_service.userprofile.dto.UserProfileResponseDto;
import com.github.user_service.userprofile.entity.UserProfile;


public class UserProfileMapper {

    public static UserProfile mapToCreateUserProfileFromDto(UserProfileRequestDto dto, User user) {
        return UserProfile.builder()
                .user(user)
                .sex(dto.getSex())
                .age(dto.getAge())
                .avatar(dto.getAvatar())
                .description(dto.getDescription())
                .city(dto.getCity())
                .userLanguages(dto.getUserLanguages())
                .build();
    }

    public static void updateUserProfileFromDto(UserProfileRequestDto userProfileRequestDto, UserProfile userProfile) {
        if (userProfileRequestDto.getSex() != null) {
            userProfile.setSex(userProfileRequestDto.getSex());
        }
        if (userProfileRequestDto.getAge() != null) {
            userProfile.setAge(userProfileRequestDto.getAge());
        }
        if (userProfileRequestDto.getAvatar() != null) {
            userProfile.setAvatar(userProfileRequestDto.getAvatar());
        }
        if (userProfileRequestDto.getDescription() != null) {
            userProfile.setDescription(userProfileRequestDto.getDescription());
        }
        if (userProfileRequestDto.getCity() != null) {
            userProfile.setCity(userProfileRequestDto.getCity());
        }
        if (userProfileRequestDto.getUserLanguages() != null && !userProfileRequestDto.getUserLanguages().isEmpty()) {
            userProfile.setUserLanguages(userProfileRequestDto.getUserLanguages());
        }
    }

    public static UserProfileResponseDto mapToGetResponse(UserProfile userProfile) {
        return UserProfileResponseDto.builder()
                .username(userProfile.getUser().getUsername())
                .sex(userProfile.getSex())
                .age(userProfile.getAge())
                .avatar(userProfile.getAvatar())
                .description(userProfile.getDescription())
                .city(userProfile.getCity())
                .userLanguages(userProfile.getUserLanguages())
                .build();
    }

}
