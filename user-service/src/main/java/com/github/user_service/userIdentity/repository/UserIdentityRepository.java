package com.github.user_service.userIdentity.repository;

import com.github.user_service.userIdentity.entity.UserIdentity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserIdentityRepository extends JpaRepository <UserIdentity, UUID> {



}
