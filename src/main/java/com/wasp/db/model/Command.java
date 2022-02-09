package com.wasp.db.model;

import com.wasp.db.exception.InvalidStatementException;
import java.util.Arrays;

public enum Command {
    SELECT("SELECT"),
    INSERT("INSERT"),
    UPDATE("UPDATE"),
    DELETE("DELETE");

    private String name;

    Command(String name) {
        this.name = name;
    }

    public static Command getCommandByName(String name) {
        return Arrays.stream(values())
            .filter(statement -> statement.name.equals(name))
            .findFirst()
            .orElseThrow(
                () -> new InvalidStatementException("No valid statement begins with " + name.toUpperCase()));
    }

}
