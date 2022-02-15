package com.wasp.db.model;

import com.wasp.db.exception.InvalidStatementException;
import java.util.Arrays;

public enum Command {
    SELECT, INSERT, UPDATE, DELETE;

    public static Command getCommandByName(String query) throws InvalidStatementException {
        return Arrays.stream(values())
            .filter(statement -> query.toUpperCase().startsWith(statement.name()))
            .findFirst()
            .orElseThrow(
                () -> new InvalidStatementException("Invalid statement: " + query.toUpperCase()));
    }
}
