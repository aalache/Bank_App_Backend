package com.example.spring_graphql.service;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.spring_graphql.dao.BankAccountRepository;
import com.example.spring_graphql.dao.CustomerRepository;
import com.example.spring_graphql.dtos.bankaccount.AddBankAccountRequest;
import com.example.spring_graphql.dtos.bankaccount.AddBankAccountResponse;
import com.example.spring_graphql.dtos.bankaccount.BankAccountDto;
import com.example.spring_graphql.enums.AccountStatus;
import com.example.spring_graphql.service.exception.BusinessException;
import com.example.spring_graphql.service.models.BankAccount;
import com.example.spring_graphql.service.models.Customer;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class BankAccountServiceImpl implements IBankAccountService{
    
    private final BankAccountRepository bankAccountRepository;
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    @Override
    public AddBankAccountResponse saveBankAccount(AddBankAccountRequest addBankAccountRequest) {
        BankAccount newBankAccount = modelMapper.map(addBankAccountRequest,BankAccount.class);
        String customer_identityRef = newBankAccount.getCustomer().getIdentityRef();
        Customer customer = customerRepository.findByIdentityRef(customer_identityRef)
            .orElseThrow(
                () -> new BusinessException(String.format("No customer with identity %s was found", customer_identityRef))
            );
        
        newBankAccount.setAccountStatus(AccountStatus.OPENED);
        newBankAccount.setCustomer(customer);
        newBankAccount.setCreatedAt(new Date());

        AddBankAccountResponse response = modelMapper.map(bankAccountRepository.save(newBankAccount), AddBankAccountResponse.class);
        response.setMessage(
            String.format("RIB number %s for the customer %s was successfuly created",response.getRib(),response.getCustomer().getUsername())
        );
        
        return response;
    }


    @Override
    public List<BankAccountDto> getAllBankAccounts() {
        return bankAccountRepository.findAll().stream()
        .map(account -> modelMapper.map(account,BankAccountDto.class))
        .toList();
    }


    @Override
    public BankAccountDto getBankAccountByRib(String rib) {
        
        BankAccount bankAccountFound = bankAccountRepository.findByRib(rib)
            .orElseThrow(
                () -> new BusinessException(String.format("No BankAccount with RIB number %s was found", rib))
            );

        return modelMapper.map(bankAccountFound, BankAccountDto.class);
    }


}
