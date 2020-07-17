package models;

import entities.Column;
import entities.Table;
import entities.TableGrantee;
import entities.User;
import utils.DbConnect;

import java.sql.SQLException;
import java.util.ArrayList;

public class TableModel {
    public ArrayList<Table> getTablesInSchema(String schema) {
        var results = new ArrayList<Table>();
        try {
            var rs = DbConnect.executeQuery(Table.query(), schema);
            while (rs.next()) {
                results.add(Table.read(rs));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return results;
    }

    private String appendColumn(Column col) {
        return col.getColumnName() + " " + col.getAttrType() + (col.isNullable() ? "" : " NOT NULL ");
    }

    public boolean createTable(String schema, String table, ArrayList<Column> listCols) {
        String sql = "CREATE TABLE " + schema + "." + table + "( ";
        int last = listCols.size() - 1;
        for (int i = 0; i < last; ++i) {
            var col = (Column)listCols.get(i);
            sql += appendColumn(col) + ", ";
        }
        sql += appendColumn(listCols.get(last));
        sql += " )";
        sql += " TABLESPACE USERS";

        try {
            System.out.println(sql);
            DbConnect.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean deleteTable(String schema, String table) {
        try {
            DbConnect.executeUpdate("DROP TABLE " + schema + "." + table);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }

        return true;
    }
}
