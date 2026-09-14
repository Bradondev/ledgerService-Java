package com.Brandon.ledger_service.exception;

import java.time.Instant;

// A plain, predictable JSON shape for every error your API returns,
// instead of Spring's default (which includes a full stack trace —
// fine for local debugging, but never something you want to expose
// to real API clients).
public class ErrorResponse {

    private Instant timestamp;
    private int status;
    private String error;
    private String message;

    public ErrorResponse() {
    }

    public ErrorResponse(int status, String error, String message) {
        this.timestamp = Instant.now();
        this.status = status;
        this.error = error;
        this.message = message;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }
}
