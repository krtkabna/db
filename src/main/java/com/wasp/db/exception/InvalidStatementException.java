package com.wasp.db.exception;

import java.sql.SQLException;

public class InvalidStatementException extends RuntimeException {
    public InvalidStatementException(String message) {
        super(message);
    }
}
