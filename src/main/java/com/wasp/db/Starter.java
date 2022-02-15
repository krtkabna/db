package com.wasp.db;

import com.wasp.db.service.QueryHandler;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Starter {
    public static void main(String[] args) throws SQLException {

        try (Connection connection = ConnectionUtil.getConnection();
             Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Enter your query: ");
                String query;
                if (!(query = scanner.nextLine()).isEmpty()) {
                    Statement statement = connection.createStatement();
                    QueryHandler queryHandler = new QueryHandler(statement, query);
                    queryHandler.handle();
                }
            }
        }
    }
}
