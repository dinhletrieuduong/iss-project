package models;

import entities.*;
import utils.DbConnect;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PermissionModel {
    public ArrayList<TableGrantee> getTableGrantees(String schema, String table) {
        var results = new ArrayList<TableGrantee>();
        try {
            var rs = DbConnect.executeQuery(TableGrantee.query(), schema, table);
            while (rs.next()) {
                results.add(TableGrantee.read(rs));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return results;
    }

    public ArrayList<TableGrantee> getTableNonGratees(String schema, String table) {
        var results = new ArrayList<TableGrantee>();
        try {
            var rs = DbConnect.executeQuery(TableGrantee.queryNonGrantees(), schema, schema, table);
            while (rs.next()) {
                results.add(TableGrantee.read(rs));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return results;
    }

    public ArrayList<TablePermission> getTablePermissions(String grantee, String schema, String table) {
        var results = new ArrayList<TablePermission>();
        try {
            var rs = DbConnect.executeQuery(TablePermission.query(), grantee, schema, table);
            while (rs.next()) {
                results.add(TablePermission.read(rs));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return results;
    }

    public ArrayList<ColumnPermission> getColumnsPermission(String grantee, String schema, String table, String priv) {
        var results = new ArrayList<ColumnPermission>();
        try {
            var rs = DbConnect.executeQuery(ColumnPermission.query(), grantee, schema, table, priv);
            while (rs.next()) {
                results.add(ColumnPermission.read(rs));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return results;
    }

    public void grant(String username, String schema, String table, String prvs, boolean grantOptions) {
        try {
            String opt = grantOptions ? " WITH GRANT OPTION" : "";
            DbConnect.executeUpdate("GRANT " + prvs + " ON " + schema + "." + table + " TO " + username + opt);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void grantColumn(String username, String schema, String table, String column, String priv, boolean grantable) {
        try {
            // revoke(username, schema, table, priv);
            String opt = grantable ? " WITH GRANT OPTION" : "";
            String query = "GRANT " + priv + "(" + column + ") ON " + schema + "." + table + " TO " + username + opt;
            System.out.println(query);
            DbConnect.executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void revoke(String username, String schema, String table, String prvs) {
        try {
            DbConnect.executeUpdate("REVOKE " + prvs + " ON " + schema + "." + table + " FROM " + username);
        } catch (SQLException throwables) {
        }
    }
}
