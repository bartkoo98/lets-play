package com.github.user_service.user.dto.mapper;

import com.github.user_service.user.dto.UserResponse;
import com.github.user_service.user.entity.User;

public class UserMapper {

    public static UserResponse mapEntityToDto(User user){
        return UserResponse
                .builder()
                .keycloakUUID(user.getKeycloakUUID())
                .username(user.getUsername())
                .build();
    }

}
