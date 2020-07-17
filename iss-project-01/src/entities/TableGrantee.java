package entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TableGrantee {
    private String grantee;

    public static String query() {
        return "SELECT DISTINCT GRANTEE FROM DBA_TAB_PRIVS " +
                "WHERE OWNER = ? AND TABLE_NAME = ?";
    }

    public static String queryNonGrantees() {
        return  "(SELECT USERNAME FROM DBA_USERS WHERE account_status = 'OPEN' AND USERNAME <> ?) " +
                "UNION " +
                "(SELECT ROLE FROM DBA_ROLES) " +
                "MINUS " + query();
    }

    public static TableGrantee read(ResultSet rs){
        TableGrantee t = new TableGrantee();

        try {
            t.grantee = rs.getString(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return t;
    }

    public String getGrantee() {
        return grantee;
    }
}
