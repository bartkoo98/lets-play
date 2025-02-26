package com.github.user_service.user.entity;

import com.github.user_service.userIdentity.entity.UserIdentity;
import com.github.user_service.userSettings.entity.UserSettings;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
public class User {

    @Id
    private Long id;
    private String username;
    private String email;
    private LocalDateTime last_login;

//    @OneToOne(cascade =  CascadeType.ALL)
//    @JoinColumn(name = "user_settings_id", referencedColumnName = "id")
//    private UserSettings userSettings;
//
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_identity_uuid", referencedColumnName = "keycloak_uuid")
//    private List<UserIdentity> userIdentityList;



}
