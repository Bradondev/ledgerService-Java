package com.Brandon.ledger_service.ledgerentry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

public interface LedgerEntryRepository extends JpaRepository<LedgerEntry, UUID> {

    // Returns all ledger entries for a given account, ordered oldest to newest.
    // Useful for building a transaction history view.
    List<LedgerEntry> findByAccountIdOrderByCreatedAtAsc(UUID accountId);

    // Returns all ledger entries belonging to a given transaction
    // (a transfer creates exactly two: one DEBIT, one CREDIT).
    List<LedgerEntry> findByTransactionId(UUID transactionId);

    // Computes the account's balance as of a given point in time by summing
    // all ledger entries for that account up to (and including) `asOf`.
    // CREDIT entries add to the balance, DEBIT entries subtract from it.
    // COALESCE(..., 0) ensures an account with zero entries returns 0
    // instead of NULL (SUM over no rows is NULL in SQL).
    @Query("""
            SELECT COALESCE(SUM(
                CASE WHEN e.entryType = com.Brandon.ledger_service.ledgerentry.EntryType.CREDIT
                     THEN e.amount
                     ELSE -e.amount
                END
            ), 0)
            FROM LedgerEntry e
            WHERE e.accountId = :accountId
              AND e.createdAt <= :asOf
            """)
    BigDecimal calculateBalance(@Param("accountId") UUID accountId, @Param("asOf") Instant asOf);
}
