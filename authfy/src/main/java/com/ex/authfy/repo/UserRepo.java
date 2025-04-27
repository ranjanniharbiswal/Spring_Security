package com.ex.authfy.repo;

import com.ex.authfy.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserEntity,Long> {

    Optional<UserEntity> findByEmail(String email);


    Boolean existsByEmail(String email);
}
