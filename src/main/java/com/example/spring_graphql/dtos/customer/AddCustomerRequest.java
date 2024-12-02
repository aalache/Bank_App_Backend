package com.example.spring_graphql.dtos.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AddCustomerRequest {
    private String identityRef;
    private String username;
    private String firstname;
    private String lastname;
}
