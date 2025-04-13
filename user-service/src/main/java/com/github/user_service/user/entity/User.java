package com.github.user_service.user.entity;

import com.github.user_service.userGameProfile.entity.UserGameProfile;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class User {

    @Id
    private Long id;
    private String keycloakUUID;
    private String username;
    @Enumerated(EnumType.STRING)
    private Sex sex;
    private Integer age;
    private String avatar;
    private String description;
    // matches, pary
    @Enumerated(EnumType.STRING)
    private City city;
    private Boolean theme;
    private Boolean notification;
    @Enumerated(EnumType.STRING)
    @Column(name = "appLanguage")
    private Language appLanguage;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<UserGameProfile> userGameProfile;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private Set<UserLanguage> languages;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKeycloakUUID() {
        return keycloakUUID;
    }

    public void setKeycloakUUID(String keycloakUUID) {
        this.keycloakUUID = keycloakUUID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Boolean getTheme() {
        return theme;
    }

    public void setTheme(Boolean theme) {
        this.theme = theme;
    }

    public Boolean getNotification() {
        return notification;
    }

    public void setNotification(Boolean notification) {
        this.notification = notification;
    }

    public Language getAppLanguage() {
        return appLanguage;
    }

    public void setAppLanguage(Language appLanguage) {
        this.appLanguage = appLanguage;
    }

    public Set<UserGameProfile> getUserGameProfile() {
        return userGameProfile;
    }

    public void setUserGameProfile(Set<UserGameProfile> userGameProfile) {
        this.userGameProfile = userGameProfile;
    }

    public Set<UserLanguage> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<UserLanguage> languages) {
        this.languages = languages;
    }
}
