package com.wasp.db.writer;

import lib.DBTablePrinter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class SelectResultWriter {
    private static final String RESOURCES_PATH = "src/main/resources/results/";
    private static final File RESOURCES_DIR = new File(RESOURCES_PATH);

    public void write(ResultSet resultSet) {
        writeToConsole(resultSet);
        writeToHtml(resultSet);
    }

    private void writeToConsole(ResultSet resultSet) {
        DBTablePrinter.printResultSet(resultSet);
    }

    private void writeToHtml(ResultSet resultSet) {
        File result = new File(RESOURCES_DIR, "result" + getIndex() + ".html");
        try (BufferedWriter bufferedWriter = new BufferedWriter(
            new FileWriter(result))) {
            ResultSetMetaData metaData = resultSet.getMetaData();
            int count = metaData.getColumnCount();

            bufferedWriter.write("<html>");
            bufferedWriter.write("<table border=1>");
            bufferedWriter.write("<tr>");

            for (int i = 1; i <= count; i++) {
                bufferedWriter.write("<th>");
                bufferedWriter.write(metaData.getColumnLabel(i).toUpperCase());
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

    private int getIndex() {
        if (!RESOURCES_DIR.exists()) {
            RESOURCES_DIR.mkdir();
        }
        File[] files = RESOURCES_DIR.listFiles();
        return files.length;
    }
}
