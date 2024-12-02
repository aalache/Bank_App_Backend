package com.example.spring_graphql.dtos.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDto {
    private Long id;
    private String username;
    private String identityRef;
    private String firsname; 
    private String lastname;
}