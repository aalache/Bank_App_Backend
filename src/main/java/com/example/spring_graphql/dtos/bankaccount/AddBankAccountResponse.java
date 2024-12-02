package com.example.spring_graphql.dtos.bankaccount;

import com.example.spring_graphql.dtos.customer.CustomerDto;
import com.example.spring_graphql.enums.AccountStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AddBankAccountResponse {
    private Long id;
    private String rib;
    private Double amount;
    private String createdAt;
    private AccountStatus accountStatus;
    private CustomerDto customer;
    private String message;
}
