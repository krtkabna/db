package com.wasp.db.exception;

public class CouldNotExecuteStatementException extends RuntimeException {
    private static final String format = "Could not execute %s";

    public CouldNotExecuteStatementException(String command) {
        super(String.format(format, command));
    }
}
