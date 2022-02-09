package com.wasp.db.queryService;

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
    private String query;

    public QueryHandler(Statement statement, String query) {
        this.statement = statement;
        this.query = query;
    }

    public void handle() {
        Command command = CommandAnalyzer.analyze(query);
        if (command.equals(Command.SELECT)) {
            handleSelect();
        } else {
            handleNonSelect();
        }
    }

    private void handleSelect() {
        SelectQueryExecutor queryExecutor = new SelectQueryExecutor(statement);
        try {
            ResultSet resultSet = queryExecutor.execute(query);
            SELECT_RESULT_WRITER.write(resultSet);
        } catch (SQLException e) {

        }
    }

    private void handleNonSelect() {
        DefaultQueryExecutor queryExecutor = new DefaultQueryExecutor(statement);
        try {
            int rows = queryExecutor.execute(query);
            NON_SELECT_RESULT_WRITER.write(query, rows);
        } catch (SQLException e) {

        }
    }
}
