package com.github.user_service.user.repository;

import com.github.user_service.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    @Query("""
    SELECT u FROM User u
    LEFT JOIN FETCH u.userProfile
    LEFT JOIN FETCH u.userGameProfiles
    WHERE u.username = :username
    """)
    Optional<User> findByUsername(@Param("username") String username);

    @Query("""
    SELECT u FROM User u
    LEFT JOIN FETCH u.userProfile
    LEFT JOIN FETCH u.userSettings
    LEFT JOIN FETCH u.userGameProfiles
    WHERE u.keycloakUUID = :keycloakUUID
    """)
    Optional<User> findWithDetailsByKeycloakUUID(@Param("keycloakUUID") String keycloakUUID);
}