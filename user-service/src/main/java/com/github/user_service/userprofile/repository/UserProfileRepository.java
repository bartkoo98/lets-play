package com.github.user_service.userprofile.repository;

import com.github.user_service.userprofile.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserProfileRepository extends JpaRepository<UserProfile,Long> {
    Optional<UserProfile> findByUserUsername(String username);
}
