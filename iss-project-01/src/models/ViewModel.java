package models;

import entities.Column;
import entities.Table;
import entities.View;
import utils.DbConnect;

import java.sql.SQLException;
import java.util.ArrayList;

public class ViewModel {
    public ArrayList<View> getViewsInSchema(String schema) {
        var results = new ArrayList<View>();
        try {
            var rs = DbConnect.executeQuery(View.query(), schema);
            while (rs.next()) {
                results.add(View.read(rs));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return results;
    }

    public void createViewFromTable(String schema, String table, String viewName, ArrayList<String> listCols) {
        String sql = "CREATE OR REPLACE VIEW " + schema + "." + viewName + " AS SELECT ";
        int last = listCols.size() - 1;
        for (int i = 0; i < last; ++i) {
            sql += listCols.get(i) + ", ";
        }
        sql += listCols.get(last);
        sql += " FROM " + schema + "."+ table;
        try {
            DbConnect.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
