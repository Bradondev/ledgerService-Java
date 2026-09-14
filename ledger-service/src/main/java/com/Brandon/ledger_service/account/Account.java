package com.Brandon.ledger_service.account;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;

// TODO: JPA entity annotations


@Entity
public class Account {

    @Id
    // TODO: fields - id, ownerId, accountType, currency, name, createdAt
    long id;
    
    String name;

    long ownerId;

    
}
