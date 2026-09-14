package com.Brandon.ledger_service.account.dto;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class BalanceResponse {

    private UUID accountId;
    private BigDecimal balance;
    private String currency;
    private Instant asOf;

    public BalanceResponse() {
    }

    public BalanceResponse(UUID accountId, BigDecimal balance, String currency, Instant asOf) {
        this.accountId = accountId;
        this.balance = balance;
        this.currency = currency;
        this.asOf = asOf;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getCurrency() {
        return currency;
    }

    public Instant getAsOf() {
        return asOf;
    }
}
