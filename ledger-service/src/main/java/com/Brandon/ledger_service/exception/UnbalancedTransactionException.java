package com.Brandon.ledger_service.exception;

import java.math.BigDecimal;

// This should never actually be thrown if TransactionService is written
// correctly — it's a defensive assertion, not an expected user-facing
// error. If this ever fires, it indicates a bug in the transfer logic
// itself, not bad input from a client.
public class UnbalancedTransactionException extends RuntimeException {

    public UnbalancedTransactionException(BigDecimal totalDebits, BigDecimal totalCredits) {
        super("Transaction is unbalanced: debits=" + totalDebits + ", credits=" + totalCredits);
    }
}
