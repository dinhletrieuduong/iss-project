package entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TablePermission {
    private String privilege;
    private String grantor;
    private boolean grantable;

    public static String query() {
        return "SELECT PRIVILEGE, GRANTOR, GRANTABLE FROM DBA_TAB_PRIVS WHERE GRANTEE = ? " +
                "AND OWNER = ? " +
                "AND TABLE_NAME =  ? " +
                "AND ( " +
                "    PRIVILEGE = 'SELECT' OR " +
                "    PRIVILEGE = 'UPDATE' OR " +
                "    PRIVILEGE = 'INSERT' OR " +
                "    PRIVILEGE = 'DELETE')";
    }

    public static TablePermission read(ResultSet rs) {
        var tp = new TablePermission();
        try {
            tp.privilege = rs.getString(1);
            tp.grantor = rs.getString(2);
            tp.grantable = (rs.getString(3).equals("YES") ? true : false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return tp;
    }

    public String getPrivilege() {
        return privilege;
    }

    public String getGrantor() {
        return grantor;
    }

    public boolean isGrantable() {
        return grantable;
    }
}
