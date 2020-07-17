package entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Role {
    private String role;
    private String password;

    public static String query() {
        return "SELECT role, authentication_type FROM dba_roles";
    }

    public static Role read(ResultSet rs) {
        Role role = new Role();

        try {
            role.role = rs.getString(1);
            role.password = rs.getString(2);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return role;
    }

    public String getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }
}
