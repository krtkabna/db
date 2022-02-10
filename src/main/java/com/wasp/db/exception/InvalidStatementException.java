package com.wasp.db.exception;

public class InvalidStatementException extends RuntimeException {
    public InvalidStatementException(String message) {
        super(message);
    }
}
