package utils;

import java.sql.*;
public class DbConnect {
    private static String getConnectionString() {
        String strf = "jdbc:oracle:thin:@%s:%s:orcl";
        return String.format(strf, Config.getHost(), Config.getPort());
    }

    public static PreparedStatement prepareStatement(String query) throws SQLException {
        String connectionString = getConnectionString();
        String username = Config.getUsername();
        String password = Config.getPassword();
//        System.out.println(connectionString);
        Connection conn = DriverManager.getConnection(connectionString, username, password);
        PreparedStatement stmt = conn.prepareStatement(query);
        return stmt;
    }

    public static String testLogin(String uname, String passwd) {
        try {
            String connectionString = getConnectionString();
            DriverManager.getConnection(connectionString, uname, passwd);
            return null;
        } catch (SQLException throwables) {
            return throwables.getMessage();
        }
    }

    public static ResultSet executeQuery(String query, Object ... objects) throws SQLException {
        PreparedStatement stmt = prepareStatement(query);
        for (int i = 0; i < objects.length; ++i) {
            stmt.setString(i + 1, objects[i].toString());
        }
//        System.out.println(stmt);
        return stmt.executeQuery();
    }

    public static int executeUpdate(String query, Object ... objects) throws SQLException {
        PreparedStatement stmt = prepareStatement(query);
        for (int i = 0; i < objects.length; ++i) {
            stmt.setString(i + 1, objects[i].toString());
        }
        return stmt.executeUpdate();
    }

    // Prevent sql injection using double quotes
    public static String executeUpdateDQ(String query, Object ... objects) throws SQLException {
        int count = 0;
        for (int i = 0; i < objects.length; ++i) {
            String temp = objects[i].toString();
            query = query.replaceFirst("\\?", "\"" + temp + "\"");
            count += 1;
        }

        if (count != objects.length) {
            System.out.println("Wrong parameters");
            return "";
        }

        executeUpdate(query);
        return query;
    }
}
