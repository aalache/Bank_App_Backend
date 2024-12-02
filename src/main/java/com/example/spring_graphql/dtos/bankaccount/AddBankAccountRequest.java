package com.example.spring_graphql.dtos.bankaccount;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AddBankAccountRequest {
    private String rib;
    private Double amount;
    private String cusomerIdentityRef;
}
