package com.wasp.db.writer;

import com.wasp.db.model.Command;

public class NonSelectResultWriter {

    public void write(Command command, int rows) {
        String name = command.name().toLowerCase();
        String suffix = name.endsWith("e") ? name + "d" : name + "ed";
        System.out.printf("Rows %s: %d%n", name + suffix, rows);
    }
}
