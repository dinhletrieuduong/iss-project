package models;

import entities.GrantableRole;
import entities.GrantedRole;
import entities.Role;
import utils.DbConnect;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RoleModel {
    public RoleModel() { }

    public ArrayList<Role> getAllRoles() {
        ArrayList<Role> results = new ArrayList<Role>();

        try {
            ResultSet rs = DbConnect.executeQuery(Role.query());
            while (rs.next()) {
                results.add(Role.read(rs));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return results;
    }

    public void grant(String username, String role, boolean grantable) {
        try {
            String opt = grantable ? " WITH ADMIN OPTION" : "";
            DbConnect.executeUpdate("GRANT " + role + " TO " + username + opt);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void revoke(String username, String role) {
        try {
            DbConnect.executeUpdate("REVOKE " + role + " FROM " + username);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ArrayList<String> getGrantableRoles(String username) {
        var results = new ArrayList<String>();
        try {
            var rs = DbConnect.executeQuery(GrantableRole.query(), username);
            while (rs.next()) {
                results.add(GrantableRole.read(rs));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return results;
    }

    public ArrayList<GrantedRole> getGrantedRoles(String username) {
        var results = new ArrayList<GrantedRole>();
        try {
            var rs = DbConnect.executeQuery(GrantedRole.query(), username);
            while (rs.next()) {
                results.add(GrantedRole.read(rs));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return results;
    }

    public boolean isRoleExisted(String role) {
        var results = getAllRoles();
        for (int i = 0; i < results.size(); ++i) {
            System.out.print(role.toUpperCase() + "==");
            System.out.println(results.get(i).getRole());
            if (role.toUpperCase().equals(results.get(i).getRole())) {
                return true;
            }
        }
        return false;
    }

    public void createRole(String uname, String passwd) {
        try {
            DbConnect.executeUpdate("CREATE ROLE " + uname);
            if (passwd.length() != 0) {
                DbConnect.executeUpdate("ALTER ROLE " + uname + " IDENTIFIED BY " + passwd);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void setRolePassword(String username, String password) {
        try {
            DbConnect.executeUpdateDQ("ALTER ROLE ? IDENTIFIED BY ?",username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
