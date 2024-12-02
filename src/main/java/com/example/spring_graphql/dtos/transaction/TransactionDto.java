package com.example.spring_graphql.dtos.transaction;

import com.example.spring_graphql.dtos.bankaccount.BankAccountDto;
import com.example.spring_graphql.dtos.user.UserDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TransactionDto {
    private Long id;
    private String createdAt;
    private String transactionType;
    private Double amount;
    private BankAccountDto  bankAccount;
    private UserDto user;   
}
