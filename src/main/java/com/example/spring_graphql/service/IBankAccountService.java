package com.example.spring_graphql.service;

import com.example.spring_graphql.dtos.bankaccount.AddBankAccountRequest;
import com.example.spring_graphql.dtos.bankaccount.AddBankAccountResponse;
import com.example.spring_graphql.dtos.bankaccount.BankAccountDto;

import java.util.List;

public interface IBankAccountService {
    AddBankAccountResponse  saveBankAccount(AddBankAccountRequest addBankAccountRequest);
    List<BankAccountDto> getAllBankAccounts();
    BankAccountDto getBankAccountByRib(String rib);
}
