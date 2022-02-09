package com.wasp.db.queryService;

import java.sql.SQLException;
import java.sql.Statement;

public class DefaultQueryExecutor {
    private Statement statement;

    public DefaultQueryExecutor(Statement statement) {
        this.statement = statement;
    }

    public int execute(String query) throws SQLException {
        return statement.executeUpdate(query);
    }
}
