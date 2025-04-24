package com.github.user_service.usersettings.dto;

import com.github.user_service.user.entity.Language;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserSettingsUpdateRequest {

    private Boolean theme;
    private Boolean notification;
    @Enumerated(EnumType.STRING)
    private Language language;

}
