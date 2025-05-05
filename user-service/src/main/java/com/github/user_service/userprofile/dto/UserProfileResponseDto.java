package com.github.user_service.userprofile.dto;

import com.github.user_service.utils.City;
import com.github.user_service.utils.Language;
import com.github.user_service.utils.Sex;
import lombok.Builder;
import lombok.Getter;

import java.util.Set;

@Getter
@Builder
public class UserProfileResponseDto {
    private String username;
    private Sex sex;
    private Integer age;
    private String avatar;
    private String description;
    private City city;
    private Set<Language> userLanguages;

}
