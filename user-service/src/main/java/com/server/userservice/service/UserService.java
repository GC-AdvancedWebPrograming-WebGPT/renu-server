package com.server.userservice.service;

import com.server.common.entity.BaseEntity;
import com.server.userservice.dto.request.SignUpRequest;
import com.server.userservice.entity.User;
import com.server.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Optional<User> getUser(String username){
        return userRepository.findByUsernameAndStatus(username, BaseEntity.Status.ACTIVE);
    }

    @Transactional
    public Long createUser(SignUpRequest signUpRequest){
        return userRepository.save(signUpRequest.toEntity()).getId();
    }

}
