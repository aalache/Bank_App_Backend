package com.example.spring_graphql.dtos.transaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AddWirerTransferResponse {
    private String message;
    private TransactionDto transactionFrom;
    private TransactionDto transactionTo;
}
