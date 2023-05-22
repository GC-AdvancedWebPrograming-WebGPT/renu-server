package com.server.userservice.user.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {

    private String username;

    private UserNutrientResponses userNutrients;

    public static UserResponse of(String username, UserNutrientResponses userNutrientResponses){
        return UserResponse.builder()
                .username(username)
                .userNutrients(userNutrientResponses)
                .build();
    }
}
