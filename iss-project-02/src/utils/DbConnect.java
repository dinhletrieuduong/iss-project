package utils;

import java.sql.*;

public class DbConnect {
    private static String connectionString = "jdbc:oracle:thin:@localhost:1521:ORCL";

    public static PreparedStatement prepareStatement(Connection conn, String query) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(query);
        return stmt;
    }

    public static Connection signIn(String uname, String passwd) {
        try {
            Connection conn = DriverManager.getConnection(connectionString, uname, passwd);
            return conn;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    public static ResultSet executeQuery(Connection conn, String query, Object ... objects) throws SQLException {
        PreparedStatement stmt = prepareStatement(conn, query);
        for (int i = 0; i < objects.length; ++i) {
            String sobj = objects[i].toString();
            stmt.setObject(i + 1, objects[i]);
        }
        return stmt.executeQuery();
    }

    public static int executeUpdate(Connection conn, String query, Object ... objects) throws SQLException {
        PreparedStatement stmt = prepareStatement(conn, query);
        for (int i = 0; i < objects.length; ++i) {
            stmt.setObject(i + 1, objects[i]);
        }
        return stmt.executeUpdate();
    }

    public static void callProcedure(Connection conn, String procedure, Object ... objects) throws SQLException {
        CallableStatement cs = conn.prepareCall("{ CALL " + procedure + " }");
        for (int i = 0; i < objects.length; ++i) {
            cs.setObject(i + 1, objects[i]);
        }
        cs.execute();
    }
}