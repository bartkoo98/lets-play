package com.github.user_service.user.entity;

import com.github.user_service.userprofile.entity.UserProfile;
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

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserProfile userProfile;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<UserGameProfile> userGameProfile;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserSettings userSettings;

}
