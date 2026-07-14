package com.orporsoft.inventory.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orporsoft.inventory.security.entity.User;

import java.util.Optional;

public interface UserRepository
        extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

}