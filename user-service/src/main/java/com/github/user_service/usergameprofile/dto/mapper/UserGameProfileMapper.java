package com.github.user_service.usergameprofile.dto.mapper;

import com.github.user_service.usergameprofile.dto.UserGameProfileCreateRequest;
import com.github.user_service.usergameprofile.dto.UserGameProfileGetResponse;
import com.github.user_service.usergameprofile.dto.UserGameProfileSaveResponse;
import com.github.user_service.usergameprofile.dto.UserGameProfileUpdateResponse;
import com.github.user_service.usergameprofile.entity.UserGameProfile;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserGameProfileMapper {

    public static UserGameProfileSaveResponse mapToDtoSaveResponse(UserGameProfile profile) {
        return UserGameProfileSaveResponse.builder()
                .game(profile.getGame())
                .elo(profile.getElo())
                .approach(profile.getApproach())
                .role(profile.getRole())
                .peak(profile.getPeak())
                .accountLink(profile.getAccountLink())
                .build();
    }

    public static UserGameProfileUpdateResponse mapToDtoUserGameProfileUpdateResponse(UserGameProfile profile){
        return UserGameProfileUpdateResponse.builder()
                .peak(profile.getPeak())
                .role(profile.getRole())
                .approach(profile.getApproach())
                .accountLink(profile.getAccountLink())
                .elo(profile.getElo())
                .build();
    }

    public static UserGameProfileGetResponse mapToDtoUserGameProfileGetResponse(UserGameProfile profile){
        return UserGameProfileGetResponse.builder()
                .peak(profile.getPeak())
                .role(profile.getRole())
                .approach(profile.getApproach())
                .accountLink(profile.getAccountLink())
                .elo(profile.getElo())
                .build();
    }

    public static UserGameProfile userGameProfileRequestToEntity(UserGameProfileCreateRequest request){
        return UserGameProfile.builder()
                .game(request.getGame())
                .elo(request.getElo())
                .approach(request.getApproach())
                .role(request.getRole())
                .peak(request.getPeak())
                .accountLink(request.getAccountLink())
                .build();
        }

    public static Set<UserGameProfileGetResponse> mapToDtoGetResponseSet(Set<UserGameProfile> profiles){

        return profiles.stream()
                .map(UserGameProfileMapper::mapToDtoUserGameProfileGetResponse)
                .collect(Collectors.toSet());

    }

    public static void mapToEntityUserGameProfileUpdate(UserGameProfile profile, UserGameProfileCreateRequest request){

        if (request.getPeak() != null){
            profile.setPeak(request.getPeak());
        }

        if (request.getElo() != null){
            profile.setElo(request.getElo());
        }

        if (request.getApproach() != null){
            profile.setApproach(request.getApproach());
        }

        if (request.getRole() != null){
            profile.setRole(request.getRole());
        }

        if (request.getAccountLink() != null){
            profile.setAccountLink(request.getAccountLink());
        }

    }


}
