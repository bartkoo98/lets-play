package com.github.user_service.user.entity;

import com.github.user_service.userprofile.entity.UserProfile;
import com.github.user_service.usergameprofile.entity.UserGameProfile;
import com.github.user_service.usersettings.entity.UserSettings;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String keycloakUUID;
    private String username;
    private boolean verified;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserProfile userProfile;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<UserGameProfile> userGameProfile;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserSettings userSettings;

}
