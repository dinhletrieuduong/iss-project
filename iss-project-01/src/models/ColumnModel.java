package models;

import entities.Column;
import utils.DbConnect;

import java.sql.SQLException;
import java.util.ArrayList;

public class ColumnModel {
    public ArrayList<Column> getColumns(String schema, String table) {
        var results = new ArrayList<Column>();
        try {
            var rs = DbConnect.executeQuery(Column.query(), schema, table);
            while (rs.next()) {
                results.add(Column.read(rs));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return results;
    }
}
