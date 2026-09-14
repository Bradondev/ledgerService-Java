package com.Brandon.ledger_service.account.dto;

import com.Brandon.ledger_service.account.Account;
import com.Brandon.ledger_service.account.AccountType;

import java.time.Instant;
import java.util.UUID;



public class AccountResponse {

  private UUID id;
  private UUID ownerId;
  private AccountType accountType;
  private String currency;
  private String name;
  private Instant createdAt;

  public AccountResponse() {
    }

    public AccountResponse(UUID id, UUID ownerId, AccountType accountType,
                            String currency, String name, Instant createdAt) {
        this.id = id;
        this.ownerId = ownerId;
        this.accountType = accountType;
        this.currency = currency;
        this.name = name;
        this.createdAt = createdAt;
    }

    // Converts a JPA entity into this API-facing DTO.
    // Keeping this conversion here (rather than in the entity or service)
    // keeps the mapping logic colocated with the shape it's producing.
    public static AccountResponse fromEntity(Account account) {
        return new AccountResponse(
                account.getId(),
                account.getOwnerId(),
                account.getAccountType(),
                account.getCurrency(),
                account.getName(),
                account.getCreatedAt()
        );
    }

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

}
