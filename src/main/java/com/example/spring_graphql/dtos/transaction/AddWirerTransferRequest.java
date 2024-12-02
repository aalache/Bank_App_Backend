package com.example.spring_graphql.dtos.transaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AddWirerTransferRequest {
    private String ribFrom;
    private String ribTo;
    private Double amount;
    private String username;
}
