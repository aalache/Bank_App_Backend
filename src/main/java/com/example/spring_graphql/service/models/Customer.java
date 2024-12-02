package com.example.spring_graphql.service.models;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Customer extends User {
    @Column(unique = true)
    private String identityRef;
    @OneToMany(mappedBy = "customer")
    private List<BankAccount> bankAccounts;
}
