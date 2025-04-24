package com.github.user_service.usergameprofile.dto;

public class UserGameProfileUpdateResponse {

    private String elo;
    private String approach;
    private String role;
    private String peak;
    private String accountLink;

    public UserGameProfileUpdateResponse() {
    }

    public UserGameProfileUpdateResponse(String elo, String approach, String role, String peak, String accountLink) {
        this.elo = elo;
        this.approach = approach;
        this.role = role;
        this.peak = peak;
        this.accountLink = accountLink;
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
}
