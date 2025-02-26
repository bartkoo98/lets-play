package com.github.user_service.userSettings.controller;

import com.github.user_service.userSettings.entity.UserSettings;
import com.github.user_service.userSettings.repository.UserSettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user-settings")
public class UserSettingsController {

    @Autowired
    private UserSettingsRepository userSettingsRepository;

    @GetMapping("/{id}")
    public ResponseEntity<UserSettings> getUserSettingsById(@PathVariable Long id){
        return userSettingsRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public UserSettings addUserSettings(@RequestBody UserSettings userSettings){
        return userSettingsRepository.save(userSettings);
    }
}
