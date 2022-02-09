package com.wasp.db.writer;

import lib.DBTablePrinter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class SelectResultWriter {
    //should only be one instance for it to work
    private int index = 0;

    public void write(ResultSet resultSet) {
        writeToConsole(resultSet);
        writeToHtml(resultSet);
    }

    private void writeToConsole(ResultSet resultSet) {
        DBTablePrinter.printResultSet(resultSet);
    }

    private void writeToHtml(ResultSet resultSet) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(
                String.format("result%s.html", index++)))) {
            ResultSetMetaData metaData = resultSet.getMetaData();
            int count = metaData.getColumnCount();

            bufferedWriter.write("<html>");
            bufferedWriter.write("<table border=1>");
            bufferedWriter.write("<tr>");

            for (int i = 1; i <= count; i++) {
                bufferedWriter.write("<th>");
                bufferedWriter.write(metaData.getColumnLabel(i));
            }

            bufferedWriter.write("</tr>");

            while (resultSet.next()) {
                bufferedWriter.write("<tr>");

                for (int i = 1; i <= count; i++) {
                    bufferedWriter.write("<td>");
                    bufferedWriter.write(resultSet.getString(i));
                }

                bufferedWriter.write("</tr>");
            }

            bufferedWriter.write("</table>");
            bufferedWriter.write("</html>");
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
