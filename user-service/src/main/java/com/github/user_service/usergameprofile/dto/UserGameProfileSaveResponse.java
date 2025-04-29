package com.github.user_service.usergameprofile.dto;

import com.github.user_service.usergameprofile.entity.Game;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserGameProfileSaveResponse {

    private Game game;
    private String elo;
    private String approach;
    private String role;
    private String peak;
    private String accountLink;

}
