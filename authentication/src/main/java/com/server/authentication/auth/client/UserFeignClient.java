package com.server.authentication.auth.client;

import com.server.authentication.auth.dto.request.SignUpRequest;
import com.server.authentication.auth.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@FeignClient("userservice")
public interface UserFeignClient {

    @GetMapping(value="/api/users", consumes = "application/json")
    Optional<User> getUser(@RequestParam("username") String username);

    @PostMapping(value="/api/users", consumes = "application/json")
    Long createUser(SignUpRequest signUpRequest);


}
