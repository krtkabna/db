package com.wasp.db.writer;

import com.wasp.db.model.Row;
import com.wasp.db.model.Table;
import java.util.List;
import java.util.StringJoiner;

public class SelectConsoleWriter {

    public void print(Table table) {
        List<String> headers = table.getHeaders();
        List<Row> rows = table.getRows();
        StringJoiner rowSeparator = new StringJoiner("╋", "┣", "┫");
        StringBuilder headerBuilder = new StringBuilder("┃");
        for (String header : headers) {
            int len = header.length();
            headerBuilder.append(centerString(len, header.trim().toUpperCase())).append("┃");
            rowSeparator.add("━".repeat(len));
        }
        printTableHeader(table.getName(), rowSeparator, headerBuilder);

        for (int i = 0; i < rows.size(); i++) {
            Row row = rows.get(i);
            for (String cell : row.getCells()) {
                System.out.print("┃" + cell);
            }
            System.out.print("┃\n");
            if (i == rows.size() - 1) {
                printLastLine(rowSeparator.toString());
                break;
            }
            System.out.println(rowSeparator);
        }
    }

    private void printTableHeader(String tableName, StringJoiner rowSeparator, StringBuilder headerBuilder) {
        System.out.println("┏" + "━".repeat(headerBuilder.length() - 2) + "┓");
        System.out.println("┃" + centerString(headerBuilder.length() - 2, tableName.toUpperCase()) + "┃");
        System.out.println(rowSeparator.toString().replace('╋', '┳'));
        System.out.println(headerBuilder);
        System.out.println(rowSeparator);
    }

    private String centerString(int width, String s) {
        return String.format("%-" + width + "s", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
    }

    private void printLastLine(String rowSeparator) {
        System.out.println(rowSeparator.replace('╋', '┻').replace('┣', '┗').replace('┫','┛'));
    }
}
