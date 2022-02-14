package com.wasp.db.model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Table {
    private String name;
    private List<String> headers;
    private List<Row> rows;

    public Table(ResultSet resultSet) throws SQLException {
        headers = new ArrayList<>();
        fillList(resultSet, headers, true);

        rows = new ArrayList<>();
        while (resultSet.next()) {
            Row row = new Row();
            List<String> cells = row.getCells();
            fillList(resultSet, cells, false);
            rows.add(row);
        }
    }

    public List<String> getHeaders() {
        return headers;
    }

    public List<Row> getRows() {
        return rows;
    }

    public String getName() {
        return name;
    }

    private void fillList(ResultSet resultSet, List<String> list, boolean isHeader) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        if (name == null) {
            name = metaData.getTableName(1);
        }
        for (int i = 1; i <= metaData.getColumnCount(); i++) {
            int columnDisplaySize = metaData.getColumnDisplaySize(i);
            String value;
            if (isHeader) {
                value = metaData.getColumnName(i);
            } else {
                value = resultSet.getString(i);
            }
            list.add(String.format("%-" + columnDisplaySize + "s", value));
        }
    }
}
