package com.wasp.db;

import com.wasp.db.service.QueryHandler;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Starter {
    public static void main(String[] args) throws SQLException {

        try (Connection connection = ConnectionUtil.getConnection();
             Statement statement = connection.createStatement();
             Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Enter your query: ");
                String query;
                while (!(query = scanner.nextLine()).isEmpty()) {
                    QueryHandler queryHandler = new QueryHandler(statement, query);
                    queryHandler.handle();
                }
            }
        }
    }
}
