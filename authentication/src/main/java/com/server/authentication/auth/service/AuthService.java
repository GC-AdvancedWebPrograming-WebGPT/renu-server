package com.server.authentication.auth.service;

import com.server.authentication.auth.client.UserFeignClient;
import com.server.authentication.auth.dto.request.LoginRequest;
import com.server.authentication.auth.dto.request.SignUpRequest;
import com.server.authentication.auth.dto.response.LoginResponse;
import com.server.authentication.auth.dto.response.SignUpResponse;
import com.server.authentication.auth.entity.User;
import com.server.authentication.common.exception.ApplicationException;
import com.server.authentication.security.JwtProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.server.authentication.common.exception.auth.AuthErrorCode.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserFeignClient userFeignClient;
    private final JwtProvider jwtProvider;

    @Transactional
    public SignUpResponse signUp(SignUpRequest signUpRequest){
        userFeignClient.getUser(signUpRequest.getUsername())
                .ifPresent(user ->{
                    throw new ApplicationException(USER_EXIST);
                });
        signUpRequest.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        return new SignUpResponse(userFeignClient.createUser(signUpRequest));
    }

    @Transactional
    public LoginResponse login(LoginRequest loginRequest){
        User user = userFeignClient.getUser(loginRequest.getUsername())
                .orElseThrow(()->new ApplicationException(USER_NOT_FOUND));

        if(!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())){
            throw new ApplicationException(INVALID_PASSWORD);
        }

        return LoginResponse.builder()
                .userId(user.getId())
                .accessToken(jwtProvider.createAccessToken(user.getId().toString()))
                .build();
    }
}
