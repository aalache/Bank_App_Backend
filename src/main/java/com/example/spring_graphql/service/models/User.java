package com.example.spring_graphql.service.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public  class User {
    
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String firstname;
    private String lastname;

    @OneToMany(mappedBy = "user")
    private List<BankAccountTransaction> BankAccountTransactionList;

    public User(String username){
        this.username = username;
    }
    
}
