package com.github.user_service.userprofile.entity;

import com.github.user_service.user.entity.*;
import com.github.user_service.utils.City;
import com.github.user_service.utils.Language;
import com.github.user_service.utils.Sex;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @Enumerated(EnumType.STRING)
    @Column(name = "sex")
    private Sex sex;
    private Integer age;
    private String avatar;
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(name = "city")
    private City city;

    @ElementCollection(targetClass = Language.class)
    @CollectionTable(name = "user_profile_languages", joinColumns = @JoinColumn(name = "user_profile_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "language")
    private Set<Language> userLanguages;

}