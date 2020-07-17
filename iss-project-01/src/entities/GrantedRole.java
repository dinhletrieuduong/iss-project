package entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GrantedRole {
    private String role;
    private String grantOption;

    public static String query() {
        return  "SELECT GRANTED_ROLE, ADMIN_OPTION FROM DBA_ROLE_PRIVS " +
                "WHERE GRANTEE = ? ";
    }

    public static GrantedRole read(ResultSet rs) {
        var gr = new GrantedRole();
        try {
            gr.role = rs.getString(1);
            gr.grantOption = rs.getString(2);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return gr;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getGrantOption() {
        return grantOption;
    }

    public void setGrantOption(String grantOption) {
        this.grantOption = grantOption;
    }
}
