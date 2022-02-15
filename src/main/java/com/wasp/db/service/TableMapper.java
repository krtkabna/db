package com.wasp.db.service;

import com.wasp.db.model.Row;
import com.wasp.db.model.Table;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TableMapper {

    public static Table mapToTable(ResultSet resultSet) throws SQLException {
        Table table = new Table();
        setTableName(resultSet, table);
        fillHeaders(resultSet, table);

        List<Row> rows = new ArrayList<>();
        while (resultSet.next()) {
            Row row = new Row();
            fillRow(resultSet, row);
            rows.add(row);
        }
        table.setRows(rows);

        return table;
    }

    private static void setTableName( ResultSet resultSet, Table table) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        if (table.getName() == null) {
            table.setName(metaData.getTableName(1));
        }
    }

    private static void fillHeaders(ResultSet resultSet, Table table) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        List<String> headers = new ArrayList<>();
        for (int i = 1; i <= metaData.getColumnCount(); i++) {
            int columnDisplaySize = metaData.getColumnDisplaySize(i);
            headers.add(String.format("%-" + columnDisplaySize + "s", metaData.getColumnName(i)));
        }
        table.setHeaders(headers);
    }
    private static void fillRow(ResultSet resultSet, Row row) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        List<Object> cells = row.getCells();
        for (int i = 1; i <= metaData.getColumnCount(); i++) {
            int columnDisplaySize = metaData.getColumnDisplaySize(i);
            cells.add(String.format("%-" + columnDisplaySize + "s", resultSet.getObject(i)));
        }
        row.setCells(cells);
    }
}
