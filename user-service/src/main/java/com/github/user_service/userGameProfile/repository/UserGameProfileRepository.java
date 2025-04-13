package com.github.user_service.userGameProfile.repository;

import com.github.user_service.user.entity.User;
import com.github.user_service.userGameProfile.entity.Game;
import com.github.user_service.userGameProfile.entity.UserGameProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserGameProfileRepository extends JpaRepository<UserGameProfile, Long> {

    List<UserGameProfile> findAllByUserId(Long userId);
    Optional<UserGameProfile> findByUserAndGame(User user, Game game);
    Set<UserGameProfile> findAllProfilesByUser(User user);


}
