package com.wasp.db;

import com.wasp.db.service.QueryHandler;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static com.wasp.db.model.AnsiColors.ANSI_RED;
import static com.wasp.db.model.AnsiColors.ANSI_RESET;

public class Starter {
    public static void main(String[] args) throws SQLException {

        try (Connection connection = ConnectionUtil.getConnection();
             Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Enter your query: ");
                String query;
                if (!(query = scanner.nextLine()).isEmpty()) {
                    try (Statement statement = connection.createStatement()) {
                        QueryHandler queryHandler = new QueryHandler(statement, query);
                        queryHandler.handle();
                    } catch (SQLException e) {
                        throw new RuntimeException("Database access error occurred or this method is called on a closed connection", e);
                    }
                } else {
                    System.out.println(ANSI_RED + "Empty query entered, exiting program" + ANSI_RESET);
                    break;
                }
            }
        }
    }
}
