package com.github.user_service.usergameprofile.entity;

import com.github.user_service.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
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

}
