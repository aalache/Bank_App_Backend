package com.example.spring_graphql.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_graphql.service.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Optional<Customer> findByIdentityRef(String identityRef);
    Optional<Customer> findByUsername(String username);
}
