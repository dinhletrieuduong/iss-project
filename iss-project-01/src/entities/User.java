package entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private int id;
    private String username;
    private String status;
    private String created;
    private String password;

    public static String query() {
        return "SELECT user_id, username, account_status, created, authentication_type FROM dba_users "
                + "WHERE account_status = 'OPEN'";
    }

    public static User read(ResultSet rs) {
        User user = new User();
        try {
            user.id = rs.getInt(1);
            user.username = rs.getString(2);
            user.status = rs.getString(3);
            user.created = rs.getString(4);
            user.password = rs.getString(5);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
