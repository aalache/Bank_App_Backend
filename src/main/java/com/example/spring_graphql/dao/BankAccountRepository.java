package com.example.spring_graphql.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_graphql.service.models.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount,Long>{
    Optional<BankAccount> findByRib(String rib);
}
