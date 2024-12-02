package com.example.spring_graphql.service.models;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import com.example.spring_graphql.enums.AccountStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class BankAccount {
    
    @Id
    @GeneratedValue
    private Long id;
    private String rib;
    private Double amount;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;

    @ManyToAny
    private Customer customer;
    @OneToMany(mappedBy = "bankAccount")
    private List<BankAccountTransaction> bankAccountTransactionList;
}
