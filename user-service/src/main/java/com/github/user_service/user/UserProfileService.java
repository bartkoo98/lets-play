package com.github.user_service.user;

import com.github.user_service.exception.UserNotFoundException;
import com.github.user_service.user.entity.User;
import com.github.user_service.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {

    private final UserRepository userRepository;

    public UserProfileService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserProfileDto createUserProfile(UserProfileCreateDto userProfileCreateDto, String username) {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User '" + username + "' not found"));

        UserMapper.createProfileFromDto(userProfileCreateDto, user);

        userRepository.save(user);

        return UserMapper.toUserProfileDto(user);
    }
}
