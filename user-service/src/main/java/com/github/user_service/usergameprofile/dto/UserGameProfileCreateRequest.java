package com.github.user_service.usergameprofile.dto;

import com.github.user_service.usergameprofile.entity.Game;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserGameProfileCreateRequest {
    @Enumerated(EnumType.STRING)
    private Game game;
    private String elo;
    private String approach;
    private String role;
    private String peak;
    private String accountLink;


}
