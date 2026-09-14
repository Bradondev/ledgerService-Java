package com.Brandon.ledger_service.account;

import com.Brandon.ledger_service.account.dto.AccountResponse;
import com.Brandon.ledger_service.account.dto.BalanceResponse;
import com.Brandon.ledger_service.account.dto.CreateAccountRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.UUID;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountResponse> createAccount(@Valid @RequestBody CreateAccountRequest request) {
        AccountResponse response = accountService.createAccount(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountResponse> getAccount(@PathVariable UUID id) {
        AccountResponse response = accountService.getAccount(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}/balance")
    public ResponseEntity<BalanceResponse> getBalance(
            @PathVariable UUID id,
            @RequestParam(required = false) Instant asOf) {
        BalanceResponse response = accountService.getBalance(id, asOf);
        return ResponseEntity.ok(response);
    }
}
