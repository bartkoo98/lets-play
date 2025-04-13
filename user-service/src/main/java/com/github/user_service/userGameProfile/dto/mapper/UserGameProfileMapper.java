package com.github.user_service.userGameProfile.dto.mapper;

import com.github.user_service.userGameProfile.dto.UserGameProfileRequest;
import com.github.user_service.userGameProfile.dto.UserGameProfileGetResponse;
import com.github.user_service.userGameProfile.dto.UserGameProfileSaveResponse;
import com.github.user_service.userGameProfile.entity.UserGameProfile;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserGameProfileMapper {

    public static UserGameProfileSaveResponse toDtoSaveResponse (UserGameProfile profile){
        UserGameProfileSaveResponse dto = new UserGameProfileSaveResponse();
        dto.setId(profile.getId());
        dto.setPeak(profile.getPeak());
        dto.setRole(profile.getRole());
        dto.setGame(profile.getGame());
        dto.setApproach(profile.getApproach());
        dto.setAccountLink(profile.getAccountLink());
        dto.setElo(profile.getElo());

        return dto;
    }

    public static UserGameProfileGetResponse toDtoGetUserProfileResponse (UserGameProfile profile){
        UserGameProfileGetResponse dto = new UserGameProfileGetResponse();
        dto.setPeak(profile.getPeak());
        dto.setRole(profile.getRole());
        dto.setApproach(profile.getApproach());
        dto.setAccountLink(profile.getAccountLink());
        dto.setElo(profile.getElo());
        dto.setGame(profile.getGame());

        return dto;
    }

    public static UserGameProfile userGameProfileRequestToEntity(UserGameProfileRequest userGameProfileRequest){
        UserGameProfile profile = new UserGameProfile();

            profile.setGame(userGameProfileRequest.getGame());
            profile.setElo(userGameProfileRequest.getElo());
            profile.setApproach(userGameProfileRequest.getApproach());
            profile.setRole(userGameProfileRequest.getRole());
            profile.setPeak(userGameProfileRequest.getPeak());
            profile.setAccountLink(userGameProfileRequest.getAccountLink());

            return profile;

        }

    public static Set<UserGameProfileGetResponse> toDtoGetResponseSet(Set<UserGameProfile> profiles){

        return profiles.stream()
                .map(UserGameProfileMapper::toDtoGetUserProfileResponse)
                .collect(Collectors.toSet());

    }

    public static void toEntityUserGameProfileUpdate(UserGameProfile profile, UserGameProfileRequest request){

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
