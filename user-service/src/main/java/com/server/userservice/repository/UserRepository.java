package com.server.userservice.repository;

import com.server.userservice.common.entity.BaseEntity;
import com.server.userservice.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByUsernameAndStatus(String username, BaseEntity.Status status);
}
