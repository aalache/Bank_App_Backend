package com.example.spring_graphql.dtos.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCustomerResponse {
    private Long id;
    private String identityRef;
    private String username;
    private String firstname;
    private String lastanme;
    private String message;
}
