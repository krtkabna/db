package com.wasp.db.writer;

import com.wasp.db.model.Command;

public class NonSelectResultWriter {

    public void write(Command command, int rows) {
        String actionPerformed = command.name().toLowerCase() + "d";
        System.out.printf("Rows %s: %d%n", actionPerformed, rows);
    }
}
