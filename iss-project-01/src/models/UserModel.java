package models;

import entities.User;
import javafx.css.CssParser;
import utils.DbConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserModel {
    public UserModel() {
    }

    public ArrayList<User> getAllUsers() {
        ArrayList<User> results = new ArrayList<User>();

        try {
            ResultSet rs = DbConnect.executeQuery(User.query());
            while (rs.next()) {
                results.add(User.read(rs));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return results;
    }

    public boolean isUserExisted(String username) {
        ArrayList<User> results = getAllUsers();
        for (int i = 0; i < results.size(); ++i) {
            System.out.print(username.toUpperCase() + "==");
            System.out.println(results.get(i).getUsername());
            if (username.toUpperCase().equals(results.get(i).getUsername())) {
                return true;
            }
        }
        return false;
    }

    public void createUser(String username, String password) {
        try {
            if (password.length() != 0) {
                DbConnect.executeUpdateDQ("CREATE USER ? IDENTIFIED BY ? QUOTA 10M ON USERS", username, password);
            } else {
                DbConnect.executeUpdateDQ("CREATE USER ?", username);
            }

            DbConnect.executeUpdateDQ("GRANT CONNECT TO ?", username);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteUser(String username) {
        try {
            DbConnect.executeUpdateDQ("DROP USER ? CASCADE", username);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void setUserPassword(String username, String password) {
        try {
            DbConnect.executeUpdateDQ("ALTER USER ? IDENTIFIED BY ?",username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
