package entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Column {
    private String columnName;
    private String attrType;
    private boolean nullable;
    private int dataLength;

    public Column() {

    }

    public Column(String colname, String type, boolean isnull) {
        columnName = colname;
        attrType = type;
        nullable = isnull;
    }

    public static String query() {
        return "SELECT COLUMN_NAME, DATA_TYPE, NULLABLE, DATA_LENGTH FROM ALL_TAB_COLUMNS WHERE OWNER = ? AND TABLE_NAME = ?";
    }

    public static Column read(ResultSet rs) {
        Column col = new Column();
        try {
            col.columnName = rs.getString(1);
            col.attrType = rs.getString(2);
            col.nullable = (rs.getString(3) == "Y" ? true : false);
            col.dataLength = rs.getInt(4);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return col;
    }

    public String getColumnName() {
        return columnName;
    }

    public boolean isNullable() {
        return nullable;
    }

    public String getAttrType() {
        return attrType;
    }

    public int getDataLength() {
        return dataLength;
    }
}
