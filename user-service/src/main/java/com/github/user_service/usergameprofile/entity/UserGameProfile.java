package com.github.user_service.usergameprofile.entity;

import com.github.user_service.user.entity.User;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

@Entity
@Table(name = "UserGameProfile")
public class UserGameProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Game game;
    private String elo;
    private String approach;
    private String role;
    private String peak;
    @Column(name = "accountLink")
    private String accountLink;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

    public UserGameProfile(Long id, Game game, String elo, String approach, String role, String peak, String accountLink, User user) {
        this.id = id;
        this.game = game;
        this.elo = elo;
        this.approach = approach;
        this.role = role;
        this.peak = peak;
        this.accountLink = accountLink;
        this.user = user;
    }
    public UserGameProfile(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String getElo() {
        return elo;
    }

    public void setElo(String elo) {
        this.elo = elo;
    }

    public String getApproach() {
        return approach;
    }

    public void setApproach(String approach) {
        this.approach = approach;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPeak() {
        return peak;
    }

    public void setPeak(String peak) {
        this.peak = peak;
    }

    public String getAccountLink() {
        return accountLink;
    }

    public void setAccountLink(String accountLink) {
        this.accountLink = accountLink;
    }

    @Nullable
    public User getUser() {
        return user;
    }

    public void setUser(@Nullable User user) {
        this.user = user;
    }
}
