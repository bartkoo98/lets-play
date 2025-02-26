package com.github.user_service.user.entity;

import com.github.user_service.userGameProfile.entity.UserGameProfile;
import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;

@Entity
public class User {

    @Id
    private Long id;
    private UUID keycloakUUID;
    private String username;
    @Enumerated(EnumType.STRING)
    private Sex sex;
    private Integer age;
    private String avatar;
    private String description;
    private String languages; // pomyslec nad przechowywaniem, czy string czy set czy kurwa co
    // matches, pary
    @Enumerated(EnumType.STRING)
    private City city;
    private Boolean theme;
    private Boolean notification;
    @Enumerated(EnumType.STRING)
    private Language appLanguage;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private Set<UserGameProfile> userGameProfile;



}
