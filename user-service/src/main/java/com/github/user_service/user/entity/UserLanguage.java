package com.github.user_service.user.entity;

import jakarta.persistence.*;

@Entity
public class UserLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Language language;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}

