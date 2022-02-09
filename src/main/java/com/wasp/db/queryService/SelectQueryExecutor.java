package com.wasp.db.queryService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectQueryExecutor {
    private Statement statement;

    public SelectQueryExecutor(Statement statement) {
        this.statement = statement;
    }

    public ResultSet execute(String query) throws SQLException {
        return statement.executeQuery(query);
    }
}
