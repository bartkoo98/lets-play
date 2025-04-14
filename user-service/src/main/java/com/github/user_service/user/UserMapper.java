package com.github.user_service.user;

import com.github.user_service.user.entity.User;

public class UserMapper {

    public static void createProfileFromDto(UserProfileCreateDto dto, User user) {
        user.setSex(dto.getSex());
        user.setAge(dto.getAge());
        user.setAvatar(dto.getAvatar());
        user.setDescription(dto.getDescription());
        user.setCity(dto.getCity());
        user.setLanguages(dto.getUserLanguages());
    }

    public static UserProfileDto toUserProfileDto(User user) {
        UserProfileDto dto = new UserProfileDto();
        dto.setSex(user.getSex());
        dto.setAge(user.getAge());
        dto.setAvatar(user.getAvatar());
        dto.setDescription(user.getDescription());
        dto.setCity(user.getCity());
        dto.setUserLanguages(user.getLanguages());
        return dto;
    }
}
