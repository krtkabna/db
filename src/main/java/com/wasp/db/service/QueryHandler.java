package com.wasp.db.service;

import com.wasp.db.exception.InvalidStatementException;
import com.wasp.db.model.Command;
import com.wasp.db.model.Table;
import com.wasp.db.writer.NonSelectResultWriter;
import com.wasp.db.writer.SelectConsoleWriter;
import com.wasp.db.writer.SelectReportWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryHandler {
    private static final SelectReportWriter SELECT_REPORT_WRITER = new SelectReportWriter();
    private static final SelectConsoleWriter SELECT_CONSOLE_WRITER = new SelectConsoleWriter();
    private static final NonSelectResultWriter NON_SELECT_RESULT_WRITER = new NonSelectResultWriter();
    private final Statement statement;
    private final String query;

    public QueryHandler(Statement statement, String query) {
        this.statement = statement;
        this.query = query;
    }

    public void handle() {
        try {
            Command command = Command.getCommandByName(query);
            if (command.equals(Command.SELECT)) {
                handleSelect();
            } else {
                handleNonSelect(command);
            }
        } catch (InvalidStatementException e) {
            System.out.println(e.getMessage());
        }
    }

    private void handleSelect() throws InvalidStatementException {
        try {
            ResultSet resultSet = statement.executeQuery(query);
            Table table = TableMapper.mapToTable(resultSet);
            SELECT_REPORT_WRITER.writeToHtml(table);
            SELECT_CONSOLE_WRITER.print(table);
        } catch (SQLException e) {
            throw new InvalidStatementException(query, e);
        }
    }

    private void handleNonSelect(Command command) throws InvalidStatementException {
        try {
            int rows = statement.executeUpdate(query);
            NON_SELECT_RESULT_WRITER.write(command, rows);
        } catch (SQLException e) {
            throw new InvalidStatementException(query, e);
        }
    }
}
