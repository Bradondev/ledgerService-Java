package com.Brandon.ledger_service.account;

import com.Brandon.ledger_service.account.dto.AccountResponse;
import com.Brandon.ledger_service.account.dto.BalanceResponse;
import com.Brandon.ledger_service.account.dto.CreateAccountRequest;
import com.Brandon.ledger_service.exception.AccountNotFoundException;
import com.Brandon.ledger_service.ledgerentry.LedgerEntryRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final LedgerEntryRepository ledgerEntryRepository;

    public AccountService(AccountRepository accountRepository,
                           LedgerEntryRepository ledgerEntryRepository) {
        this.accountRepository = accountRepository;
        this.ledgerEntryRepository = ledgerEntryRepository;
    }

    public AccountResponse createAccount(CreateAccountRequest request) {
        Account account = new Account(
                request.getOwnerId(),
                request.getAccountType(),
                request.getCurrency(),
                request.getName()
        );

        Account saved = accountRepository.save(account);
        return AccountResponse.fromEntity(saved);
    }

    public AccountResponse getAccount(UUID id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException(id));

        return AccountResponse.fromEntity(account);
    }

    public BalanceResponse getBalance(UUID id, Instant asOf) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException(id));

        Instant effectiveAsOf = (asOf != null) ? asOf : Instant.now();
        BigDecimal balance = ledgerEntryRepository.calculateBalance(id, effectiveAsOf);

        return new BalanceResponse(account.getId(), balance, account.getCurrency(), effectiveAsOf);
    }
}
