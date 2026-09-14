package com.Brandon.ledger_service.account;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "owner_id")
    private UUID ownerId;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_type", nullable = false)
    private AccountType accountType;

    @Column(nullable = false, length = 3)
    private String currency;

    @Column(nullable = false)
    private String name;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    // JPA requires a no-arg constructor so Hibernate can instantiate
    // this class via reflection before populating its fields.
    protected Account() {
    }

    // Constructor for actually creating new accounts in your code.
    public Account(UUID ownerId, AccountType accountType, String currency, String name) {
        this.ownerId = ownerId;
        this.accountType = accountType;
        this.currency = currency;
        this.name = name;
    }

    @PrePersist
    protected void onCreate() {
        if (createdAt == null) {
            createdAt = Instant.now();
        }
    }

    // --- Getters ---

    public UUID getId() {
        return id;
    }

    public UUID getOwnerId() {
        return ownerId;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public String getCurrency() {
        return currency;
    }

    public String getName() {
        return name;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    // --- Setters ---
    // Note: no setter for `id` or `createdAt` — these should never be
    // mutated after creation. Letting JPA manage `id` and the
    // @PrePersist hook manage `createdAt` keeps them safe from
    // accidental changes elsewhere in the codebase.

    public void setOwnerId(UUID ownerId) {
        this.ownerId = ownerId;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setName(String name) {
        this.name = name;
    }
}
