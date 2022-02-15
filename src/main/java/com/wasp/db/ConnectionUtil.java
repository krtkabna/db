package com.wasp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/school";
    private static final String DB_USER = "wasp";
    private static final String DB_PSWD = "root";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PSWD);
        } catch (SQLException e) {
            throw new RuntimeException("Unable to connect to database", e);
        }
    }
}
