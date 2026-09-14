package com.Brandon.ledger_service.exception;

import java.util.UUID;

// A "runtime" (unchecked) exception, not a checked one — this means callers
// (like AccountController) are not forced to wrap every call in try/catch
// or declare "throws". It's meant to propagate up automatically until
// GlobalExceptionHandler catches it and converts it into an HTTP response.
public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException(UUID accountId) {
        super("Account not found: " + accountId);
    }
}
