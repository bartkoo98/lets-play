package com.github.user_service.userIdentity.entity;

import com.github.user_service.user.entity.User;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class UserIdentity {

    @Id
    private UUID keycloakUUID;
    @Enumerated(EnumType.STRING)
    private Provider identityProvider;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;




}
