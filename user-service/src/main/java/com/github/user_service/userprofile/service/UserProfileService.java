package com.github.user_service.userprofile.service;

import com.github.user_service.exception.ResourceNotFoundException;
import com.github.user_service.user.entity.User;
import com.github.user_service.user.repository.UserRepository;
import com.github.user_service.userprofile.dto.UserProfileRequestDto;
import com.github.user_service.userprofile.dto.UserProfileResponseDto;
import com.github.user_service.userprofile.dto.mapper.UserProfileMapper;
import com.github.user_service.userprofile.entity.UserProfile;
import com.github.user_service.userprofile.repository.UserProfileRepository;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserProfileService {

    private final UserRepository userRepository;
    private final UserProfileRepository userProfileRepository;

    public UserProfileService(UserRepository userRepository, UserProfileRepository userProfileRepository) {
        this.userRepository = userRepository;
        this.userProfileRepository = userProfileRepository;
    }

    public void createUserProfile(UserProfileRequestDto userProfileRequestDto, String username, Jwt jwt) {
        String loggedUsername = jwt.getClaimAsString("preferred_username");

        if (!Objects.equals(username, loggedUsername)) {
            throw new AccessDeniedException("You cannot create user profile as: " + loggedUsername + "for the account of: " + username);
        }

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        UserProfile userProfile = UserProfileMapper.mapToCreateUserProfileFromDto(userProfileRequestDto, user);

        userProfileRepository.save(userProfile);
    }

    public void updateUserProfile(UserProfileRequestDto userProfileRequestDto, String username, Jwt jwt) {
        String loggedUsername = jwt.getClaimAsString("preferred_username");

        if (!Objects.equals(username, loggedUsername)) {
            throw new AccessDeniedException("You cannot modify not your profile!");
        }

        UserProfile userProfile = userProfileRepository.findByUserUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("user profile", "username", username));

        UserProfileMapper.updateUserProfileFromDto(userProfileRequestDto, userProfile);

        userProfileRepository.save(userProfile);
    }

    public UserProfileResponseDto getUserProfile(String username) {
        UserProfile userProfile = userProfileRepository.findByUserUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("user profile", "username", username));

        return UserProfileMapper.mapToGetResponse(userProfile);
    }

}

