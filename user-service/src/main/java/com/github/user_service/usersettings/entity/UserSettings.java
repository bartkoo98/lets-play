package com.github.user_service.usersettings.entity;

import com.github.user_service.user.entity.Language;
import com.github.user_service.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class UserSettings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean theme;
    private Boolean notification;

    @Enumerated(EnumType.STRING)
    @Column(name = "appLanguage")
    private Language language;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

}
