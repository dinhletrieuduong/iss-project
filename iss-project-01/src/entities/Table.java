package entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Table {
    private String schema;
    private String name;

    public static String query() {
        return  "SELECT OWNER, OBJECT_NAME FROM DBA_OBJECTS " +
                "WHERE OBJECT_TYPE = 'TABLE' AND OWNER = ?";
    }

    public static Table read(ResultSet rs) {
        Table tb = new Table();
        try {
            tb.schema = rs.getString(1);
            tb.name = rs.getString(2);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return tb;
    }

    public String getName() {
        return name;
    }

    public String getSchema() {
        return schema;
    }
}
