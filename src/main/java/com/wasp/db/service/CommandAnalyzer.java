package com.wasp.db.service;

import com.wasp.db.model.Command;

public class CommandAnalyzer {
    public static Command analyze(String query) {
        return Command.getCommandByName(query);
    }
}
