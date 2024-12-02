package com.example.spring_graphql.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_graphql.service.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
}
