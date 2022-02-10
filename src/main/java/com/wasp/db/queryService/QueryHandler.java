package com.wasp.db.queryService;

import com.wasp.db.exception.CouldNotExecuteStatementException;
import com.wasp.db.model.Command;
import com.wasp.db.writer.NonSelectResultWriter;
import com.wasp.db.writer.SelectResultWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryHandler {
    private static final SelectResultWriter SELECT_RESULT_WRITER = new SelectResultWriter();
    private static final NonSelectResultWriter NON_SELECT_RESULT_WRITER = new NonSelectResultWriter();
    private final Statement statement;
    private final String query;

    public QueryHandler(Statement statement, String query) {
        this.statement = statement;
        this.query = query;
    }

    public void handle() {
        Command command = CommandAnalyzer.analyze(query);
        if (command.equals(Command.SELECT)) {
            handleSelect();
        } else {
            handleNonSelect(command);
        }
    }

    private void handleSelect() {
        try {
            ResultSet resultSet = statement.executeQuery(query);
            SELECT_RESULT_WRITER.write(resultSet);
        } catch (SQLException e) {
            throw new CouldNotExecuteStatementException("SELECT");
        }
    }

    private void handleNonSelect(Command command) {
        try {
            int rows = statement.executeUpdate(query);
            NON_SELECT_RESULT_WRITER.write(command, rows);
        } catch (SQLException e) {
            throw new CouldNotExecuteStatementException(command.name());
        }
    }
}
