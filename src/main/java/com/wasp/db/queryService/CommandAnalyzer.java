package com.wasp.db.queryService;

import com.wasp.db.model.Command;

public class CommandAnalyzer {
    public static Command analyze(String query) {
        String commandName = query.split(" ")[0];
        return Command.getCommandByName(commandName);
    }
}
