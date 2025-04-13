package com.github.user_service.userGameProfile.dto;

import com.github.user_service.userGameProfile.entity.Game;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;


public class UserGameProfileRequest {
    @NotNull
    private Long id;
    @Enumerated(EnumType.STRING)
    private Game game;
    private String elo;
    private String approach;
    private String role;
    private String peak;
    private String accountLink;

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

    public UserGameProfileRequest(Game game, String elo, String approach, String role, String peak, String accountLink) {

        this.game = game;
        this.elo = elo;
        this.approach = approach;
        this.role = role;
        this.peak = peak;
        this.accountLink = accountLink;
    }

}
