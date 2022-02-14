package com.wasp.db.writer;

import com.wasp.db.model.Row;
import com.wasp.db.model.Table;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class SelectReportWriter {
    private static final String RESOURCES_PATH = "src/main/resources/results/";
    private static final File RESOURCES_DIR = new File(RESOURCES_PATH);

    public void writeToHtml(Table table) {
        File result = new File(RESOURCES_DIR, "result" + new Date().getTime() + ".html");
        System.out.println("Started writing to file: " + result.getName());
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(result))) {
            List<String> headers = table.getHeaders();
            List<Row> rows = table.getRows();

            bufferedWriter.write("<html><table border=1>");
            bufferedWriter.write("<tr>");
            for (String header : headers) {
                bufferedWriter.write("<th>" + header + "</th>");
            }
            bufferedWriter.write("<tr>");

            for (Row row : rows) {
                for (int i = 0; i < headers.size(); i++) {
                    bufferedWriter.write("<td>" + row.getCells().get(i) + "</td>");
                }
                bufferedWriter.write("<tr>");
            }

            bufferedWriter.write("</table></html>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}