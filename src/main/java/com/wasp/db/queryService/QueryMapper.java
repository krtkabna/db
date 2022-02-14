//package com.wasp.db.queryService;
//
//import com.jakewharton.fliptables.FlipTable;
//import com.jakewharton.fliptables.FlipTableConverters;
//import com.wasp.db.model.QueryResult;
//import io.bretty.console.table.Table;
//import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class QueryMapper {
//
//    public static QueryResult map(ResultSet resultSet) throws SQLException {
//        ResultSetMetaData metaData = resultSet.getMetaData();
//        int columnCount = metaData.getColumnCount();
//        Map<String, List<Object>> fields = new HashMap<>();
//        for (int i = 1; i <= columnCount; i++) {
//            fields.put(metaData.getColumnName(i), new ArrayList<>());
//        }
//        while (resultSet.next()) {
//            for (String columnName : fields.keySet()) {
//                fields.get(columnName).add(resultSet.getString(columnName));
//            }
//        }
//        int width = fields.get(metaData.getColumnLabel(1)).size();
//        return new QueryResult(metaData.getTableName(1), fields, width);
//    }
//
//    public static String stringRepresentation(ResultSet resultSet) throws SQLException {
//        return FlipTableConverters.fromResultSet(resultSet);
//    }
//
//    public static Table fromRS(ResultSet resultSet) throws SQLException {
//        List<String> headers = new ArrayList<>();
//        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
//        int columnCount = resultSetMetaData.getColumnCount();
//
//        for(int column = 0; column < columnCount; ++column) {
//            headers.add(resultSetMetaData.getColumnName(column + 1));
//        }
//
//        List<Object> data = new ArrayList<>();
//
//        String[] rowData;
//        while(resultSet.next()) {
//            rowData = new String[columnCount];
//
//            for(int column = 0; column < columnCount; column++) {
//                rowData[column] = resultSet.getString(column + 1);
//            }
//
//            data.add(rowData);
//        }
//
//        rowData = (String[])headers.toArray(new String[headers.size()]);
//        String[][] dataArray = (String[][])data.toArray(new String[data.size()][]);
//        return new Table(rowData, dataArray);
//    }
//
////    public static Table mapToTable(ResultSet resultSet) throws SQLException {
////        ResultSetMetaData metaData = resultSet.getMetaData();
////        int columnCount = metaData.getColumnCount();
////        String[] columnNames = new String[columnCount + 1];
////        int[] displaySizes = new int[columnCount + 1];
////        for (int i = 1; i <= columnCount; i++) {
////            columnNames[i] = metaData.getColumnLabel(i);
////            displaySizes[i] = metaData.getColumnDisplaySize(i);
////        }
////
////        Object[][] result = new Object[columnNames.length][];
////        while (resultSet.next()) {
////            Object[] res = new Object[columnNames.length];
////            for (int i = 1; i <= columnCount; i++) {
////                res[i] = resultSet.getString(i);
////            }
////        }
////
////    }
////
////    public static Object[][] map(QueryResult queryResult) {
////        int columnCount = queryResult.getFields().keySet().size();
////        int rowCount = queryResult.getWidth();
////        Object[][] table = new Object[columnCount][rowCount];
////        for (int i = 0; i < columnCount; i++) {
////            for (int j = 0; j < rowCount; j++) {
////                table[i][j] = queryResult.getFields().get(m)
////            }
////        }
////    }
////
////    private
//}
