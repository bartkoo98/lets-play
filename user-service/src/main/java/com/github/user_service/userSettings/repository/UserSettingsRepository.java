package com.github.user_service.userSettings.repository;

import com.github.user_service.userSettings.entity.UserSettings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSettingsRepository extends JpaRepository<UserSettings, Long> {
}
