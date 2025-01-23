package com.github.user_service.entity;

import jakarta.persistence.*;

@Entity
public class UserSettings {

    @Id
    private Long id;
    private boolean theme;
    private boolean notification;
    @Enumerated(EnumType.STRING)
    private Language language;

//    @OneToOne(mappedBy = "user_id")
//    @JoinColumn(name = "user_id")
//    private long user_id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isTheme() {
        return theme;
    }

    public void setTheme(boolean theme) {
        this.theme = theme;
    }

    public boolean isNotification() {
        return notification;
    }

    public void setNotification(boolean notification) {
        this.notification = notification;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
