package com.github.user_service.user.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "UserPair",
        uniqueConstraints = @UniqueConstraint(columnNames = {"user1_id", "user2_id"})
)
public class UserPair {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user1_id", nullable = false)
    private User user1;

    @ManyToOne
    @JoinColumn(name = "user2_id", nullable = false)
    private User user2;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status = Status.PENDING;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();



}
