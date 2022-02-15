package com.wasp.db.exception;

import static com.wasp.db.model.AnsiColors.ANSI_RESET;
import static com.wasp.db.model.AnsiColors.ANSI_YELLOW;

public class InvalidStatementException extends Exception {
    public InvalidStatementException(String message) {
        super(message);
    }

    public InvalidStatementException(String query, Throwable cause) {
        super("Invalid SQL statement: " + ANSI_YELLOW + query + ANSI_RESET, cause);
    }
}
