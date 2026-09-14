package com.Brandon.ledger_service.exception;

public class DuplicateTransactionException extends RuntimeException {

    public DuplicateTransactionException(String idempotencyKey) {
        super("Transaction already exists for idempotency key: " + idempotencyKey);
    }
}
