package com.wasp.db.writer;

import java.sql.SQLException;
import java.sql.Statement;

public class NonSelectResultWriter {
    public void write(String query, int rows) throws SQLException {
        System.out.println("Query:        " + query);
        System.out.println("Rows changed: " + rows);
    }
}
