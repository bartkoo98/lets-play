package com.github.user_service.usergameprofile.repository;

import com.github.user_service.user.entity.User;
import com.github.user_service.usergameprofile.entity.Game;
import com.github.user_service.usergameprofile.entity.UserGameProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface UserGameProfileRepository extends JpaRepository<UserGameProfile, Long> {

    Optional<UserGameProfile> findByUserAndGame(User user, Game game);
    Set<UserGameProfile> findAllGameProfilesByUser(User user);


}
