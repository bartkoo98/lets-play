package com.github.user_service.usergameprofile.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserGameProfileGetResponse {
    private String elo;
    private String approach;
    private String role;
    private String peak;
    private String accountLink;
}
