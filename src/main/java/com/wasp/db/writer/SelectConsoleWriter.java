package com.wasp.db.writer;

import com.wasp.db.model.Row;
import com.wasp.db.model.Table;
import java.util.List;

public class SelectConsoleWriter {

    public void print(Table table) {
        List<String> headers = table.getHeaders();
        List<Row> rows = table.getRows();

        int width = headers.size() + 1;
        for (String header : headers) {
            System.out.print("|" + header);
            width += header.length();
        }
        System.out.print("|\n");
        System.out.println("-".repeat(width));

        for (Row row : rows) {
            for (String cell : row.getCells()) {
                System.out.print("|" + cell);
            }
            System.out.print("|\n");
        }
    }
}
