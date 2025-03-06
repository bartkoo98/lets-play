package com.github.user_service.userGameProfile.entity;

import com.github.user_service.user.entity.User;
import jakarta.persistence.*;

@Entity
public class UserGameProfile {

    @Id
    private Long id;
    @Enumerated(EnumType.STRING)
    private Game game;
    private String elo;
    private String approach;
    private String role;
    private String peak;
    private String accountLink;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
