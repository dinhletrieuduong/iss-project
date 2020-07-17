//package sample;
package entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Auditing
{
    private String username;
    private String owner;
    private String object_name;
    private String action;
    private String sql_text;

    public static String query1()
    {
        return "SELECT USERNAME, OWNER, OBJ_NAME, ACTION_NAME, SQL_TEXT " +
                "FROM DBA_AUDIT_TRAIL";
    }

    public static String query2(String username, String table)
    {
        return "AUDIT ALL ON " + username + "." + table + " BY ACCESS";
    }

    public static String query3(String username, String table)
    {
        return "NOAUDIT ALL ON " + username + "." + table + " BY ACCESS";
    }

    public static Auditing read(ResultSet rs) {
        Auditing Auditing = new Auditing();
        try {
            Auditing.username = rs.getString(1);
            Auditing.owner = rs.getString(2);
            Auditing.object_name = rs.getString(3);
            Auditing.action = rs.getString(4);
            Auditing.sql_text = rs.getString(5);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Auditing;
    }

    public Auditing() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getObject_name() {
        return object_name;
    }

    public void setObject_name(String object_name) {
        this.object_name = object_name;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getSql_text() {
        return sql_text;
    }

    public void setSql_text(String sql_text) {
        this.sql_text = sql_text;
    }


}
