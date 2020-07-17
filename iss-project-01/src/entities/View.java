package entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class View {
    private String schema;
    private String name;
    private String text;

    public static String query() {
        return  "SELECT OWNER, VIEW_NAME, TEXT FROM DBA_VIEWS " +
                "WHERE OWNER = ?";
    }

    public static View read(ResultSet rs) {
        View tb = new View();
        try {
            tb.schema = rs.getString(1);
            tb.name = rs.getString(2);
            tb.text = rs.getString(3);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return tb;
    }

    public String getName() {
        return name;
    }

    public String getSchema() {
        return schema;
    }

    public String getText() {
        return text;
    }
}
