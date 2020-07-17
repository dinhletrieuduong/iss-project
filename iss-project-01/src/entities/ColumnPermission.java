package entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ColumnPermission {
    private String colName;
    private boolean grantable;

    public static String query() {
        return  "SELECT COLUMN_NAME, GRANTABLE " +
                "FROM DBA_COL_PRIVS " +
                "WHERE GRANTEE = ? AND OWNER = ? AND TABLE_NAME = ? AND PRIVILEGE = ?";
    }

    public static ColumnPermission read(ResultSet rs) {
        var priv = new ColumnPermission();
        try {
            priv.colName = rs.getString(1);
            priv.grantable = (rs.getString(2).equals("YES") ? true : false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return priv;
    }

    public String getColName() {
        return colName;
    }

    public boolean isGrantable() {
        return grantable;
    }
}
