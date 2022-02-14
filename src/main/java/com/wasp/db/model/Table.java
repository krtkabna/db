package com.wasp.db.model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Table {
    private List<String> headers;
    private List<Row> rows;

    public Table(ResultSet resultSet) throws SQLException {
        headers = new ArrayList<>();
        rows = new ArrayList<>();

        ResultSetMetaData metaData = resultSet.getMetaData();
//        for (int i = 1; i <= metaData.getColumnCount(); i++) {
//            int columnDisplaySize = metaData.getColumnDisplaySize(i);
//            headers.add(String.format("%" + columnDisplaySize + "s", metaData.getColumnName(i)));
//        }
        fillList(resultSet, headers, true);

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

    private void fillList(ResultSet resultSet, List<String> list, boolean isHeader) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        for (int i = 1; i <= metaData.getColumnCount(); i++) {
            int columnDisplaySize = metaData.getColumnDisplaySize(i);
            String value;
            if (isHeader) {
                value = metaData.getColumnName(i);
            } else {
                value = resultSet.getString(i);
            }
            list.add(String.format("%" + columnDisplaySize + "s", value));
        }
    }
}
