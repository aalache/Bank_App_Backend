package com.example.spring_graphql.dao;




import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_graphql.service.models.BankAccountTransaction;

import java.sql.Date;
import java.util.List;


public interface BankAccountTransactionRepository extends JpaRepository<BankAccountTransaction,Long>{
    List<BankAccountTransaction> findByBankAccount_RibAndCreatedAtBetween(String rib,Date from,Date To);
}
