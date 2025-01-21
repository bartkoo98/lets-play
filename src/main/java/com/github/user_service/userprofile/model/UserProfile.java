package com.github.user_service.userprofile.model;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;
    @Enumerated(EnumType.STRING)
    private Sex sex;
    private String avatarUrl;
    private String profileDescription;
    private String languages;
    private String city;

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
}
