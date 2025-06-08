package com.github.user_service.usersettings.entity;

import com.github.user_service.utils.Language;
import com.github.user_service.user.entity.User;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
