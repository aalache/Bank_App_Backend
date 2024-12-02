package com.example.spring_graphql.service;

import com.example.spring_graphql.dtos.transaction.AddWirerTransferRequest;
import com.example.spring_graphql.dtos.transaction.AddWirerTransferResponse;
import com.example.spring_graphql.dtos.transaction.GetTransactionListRequest;
import com.example.spring_graphql.dtos.transaction.TransactionDto;

import java.util.List;

public interface ITransactionService {

  AddWirerTransferResponse wirerTransfer(AddWirerTransferRequest dto);
  List<TransactionDto> getTransactions(GetTransactionListRequest dto);  
} 
