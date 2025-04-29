package com.github.user_service.user.entity;

import com.github.user_service.usergameprofile.entity.UserGameProfile;
import com.github.user_service.usersettings.entity.UserSettings;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class User {

    @Id
    private Long id;
    private String keycloakUUID;
    private String username;
    @Enumerated(EnumType.STRING)
    private Sex sex;
    private Integer age;
    private String avatar;
    private String description;
    @Enumerated(EnumType.STRING)
    private City city;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<UserGameProfile> userGameProfile;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private Set<UserLanguage> languages;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserSettings userSettings;

}
