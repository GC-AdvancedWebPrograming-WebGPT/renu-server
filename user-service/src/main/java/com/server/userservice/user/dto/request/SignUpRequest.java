package com.server.userservice.user.dto.request;

import com.server.userservice.user.entity.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpRequest {

    private String username;
    private String password;

    public User toEntity(){
        return User.builder()
                .username(this.username)
                .password(this.password)
                .build();

    }
}
