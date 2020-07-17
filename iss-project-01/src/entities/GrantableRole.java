package entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GrantableRole {
    public static String query() {
        return  "SELECT ROLE FROM DBA_ROLES " +
                "MINUS " +
                "SELECT GRANTED_ROLE FROM DBA_ROLE_PRIVS " +
                "WHERE GRANTEE = ?";
    }

    public static String read(ResultSet rs) {
        String result = "";
        try {
            result = rs.getString(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
}
