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

    public static UserGameProfileSaveResponse mapToDtoSaveResponse(UserGameProfile profile){
        return new UserGameProfileSaveResponse(profile.getGame(), profile.getElo(), profile.getApproach(),
                profile.getRole(), profile.getPeak(), profile.getAccountLink());
    }

    public static UserGameProfileUpdateResponse mapToDtoUserGameProfileUpdateResponse(UserGameProfile profile){
        UserGameProfileUpdateResponse dto = new UserGameProfileUpdateResponse();
        dto.setPeak(profile.getPeak());
        dto.setRole(profile.getRole());
        dto.setApproach(profile.getApproach());
        dto.setAccountLink(profile.getAccountLink());
        dto.setElo(profile.getElo());

        return dto;
    }

    public static UserGameProfileGetResponse mapToDtoUserGameProfileGetResponse(UserGameProfile profile){
        UserGameProfileGetResponse dto = new UserGameProfileGetResponse();
        dto.setPeak(profile.getPeak());
        dto.setRole(profile.getRole());
        dto.setApproach(profile.getApproach());
        dto.setAccountLink(profile.getAccountLink());
        dto.setElo(profile.getElo());

        return dto;
    }

    public static UserGameProfile userGameProfileRequestToEntity(UserGameProfileCreateRequest userGameProfileCreateRequest){
        UserGameProfile profile = new UserGameProfile();

            profile.setGame(userGameProfileCreateRequest.getGame());
            profile.setElo(userGameProfileCreateRequest.getElo());
            profile.setApproach(userGameProfileCreateRequest.getApproach());
            profile.setRole(userGameProfileCreateRequest.getRole());
            profile.setPeak(userGameProfileCreateRequest.getPeak());
            profile.setAccountLink(userGameProfileCreateRequest.getAccountLink());

            return profile;

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
