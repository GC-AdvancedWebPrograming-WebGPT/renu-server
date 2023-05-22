package com.server.userservice.user.controller;

import com.server.userservice.user.dto.request.SignUpRequest;
import com.server.userservice.user.dto.response.UserNutrientResponses;
import com.server.userservice.user.dto.response.UserResponse;
import com.server.userservice.user.entity.User;
import com.server.userservice.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("")
    public Optional<User> getUser(@RequestParam("username") String username){
        return userService.getUser(username);
    }

    @PostMapping("")
    public Long createUser(@RequestBody SignUpRequest signUpRequest){
        return userService.createUser(signUpRequest);
    }

    @GetMapping("/me")
    public UserResponse getMe(@RequestHeader("user_id") String userId){
        return userService.getMe(userId);
    }
}
