package com.server.authentication.auth.service;

import com.server.authentication.auth.client.UserFeignClient;
import com.server.authentication.auth.dto.request.SignUpRequest;
import com.server.authentication.auth.dto.response.SignUpResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserFeignClient userFeignClient;

    @Transactional
    public SignUpResponse signUp(SignUpRequest signUpRequest){
        userFeignClient.getUser(signUpRequest.getUsername())
                .ifPresent(user ->{
                    throw new RuntimeException("이미 존재하는 유저입니다.");
                });
        signUpRequest.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        return new SignUpResponse(userFeignClient.createUser(signUpRequest));
    }
}
