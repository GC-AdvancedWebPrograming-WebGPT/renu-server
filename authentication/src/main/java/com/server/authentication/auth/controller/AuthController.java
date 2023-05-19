package com.server.authentication.auth.controller;

import com.server.authentication.auth.dto.request.LoginRequest;
import com.server.authentication.auth.dto.request.SignUpRequest;
import com.server.authentication.auth.dto.response.LoginResponse;
import com.server.authentication.auth.dto.response.SignUpResponse;
import com.server.authentication.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/sign-up")
    public SignUpResponse signUp(@RequestBody SignUpRequest signUpRequest){
        return authService.signUp(signUpRequest);
    }

    @PostMapping("login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest){
        return authService.login(loginRequest);
    }

}
