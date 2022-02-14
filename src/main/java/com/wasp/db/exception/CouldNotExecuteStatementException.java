package com.wasp.db.exception;

public class CouldNotExecuteStatementException extends RuntimeException {
    private static final String format = "Could not execute %s";

    public CouldNotExecuteStatementException(String command, Throwable cause) {
        super(String.format(format, command), cause);
    }
}
