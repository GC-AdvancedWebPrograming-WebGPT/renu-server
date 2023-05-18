package com.server.userservice.controller;

import com.server.userservice.dto.request.SignUpRequest;
import com.server.userservice.entity.User;
import com.server.userservice.service.UserService;
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
}
