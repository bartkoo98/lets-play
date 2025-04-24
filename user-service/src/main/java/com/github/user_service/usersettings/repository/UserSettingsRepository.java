package com.github.user_service.usersettings.repository;

import com.github.user_service.user.entity.User;
import com.github.user_service.usersettings.entity.UserSettings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserSettingsRepository extends JpaRepository <UserSettings, Long> {
    Optional<UserSettings> findByUser(User user);
}
