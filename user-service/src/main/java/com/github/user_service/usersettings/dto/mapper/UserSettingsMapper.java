package com.github.user_service.usersettings.dto.mapper;

import com.github.user_service.usersettings.dto.UserSettingsUpdateRequest;
import com.github.user_service.usersettings.dto.UserSettingsUpdateResponse;
import com.github.user_service.usersettings.entity.UserSettings;
import org.springframework.stereotype.Component;

@Component
public class UserSettingsMapper {

    public static void mapToEntityUserSettings(UserSettings settings, UserSettingsUpdateRequest request){

        if (request.getLanguage() != null){
            settings.setLanguage(request.getLanguage());
        }
        if (request.getNotification() != null){
            settings.setNotification(request.getNotification());
        }
        if (request.getTheme() != null){
            settings.setTheme(request.getTheme());
        }
    }

    public static UserSettingsUpdateResponse mapToDtoUserSettingsUpdateResponse(UserSettings settings){
        return UserSettingsUpdateResponse.builder()
                .theme(settings.getTheme())
                .notification(settings.getNotification())
                .language(settings.getLanguage()).build();
    }

}
