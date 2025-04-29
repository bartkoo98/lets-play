package com.github.user_service.usergameprofile.dto;

import com.github.user_service.usergameprofile.entity.Game;

public class UserGameProfileGetResponse {
    private String elo;
    private String approach;
    private String role;
    private String peak;
    private String accountLink;
    private Game game;

    public UserGameProfileGetResponse(String elo, String approach, String role, String peak, String accountLink, Game game) {
        this.elo = elo;
        this.approach = approach;
        this.role = role;
        this.peak = peak;
        this.accountLink = accountLink;
        this.game = game;
    }

    public UserGameProfileGetResponse() {

    }


    public String getAccountLink() {
        return accountLink;
    }

    public void setAccountLink(String accountLink) {
        this.accountLink = accountLink;
    }

    public String getPeak() {
        return peak;
    }

    public void setPeak(String peak) {
        this.peak = peak;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getApproach() {
        return approach;
    }

    public void setApproach(String approach) {
        this.approach = approach;
    }

    public String getElo() {
        return elo;
    }

    public void setElo(String elo) {
        this.elo = elo;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
