package gui.entities;


import javafx.scene.control.CheckBox;

import java.awt.*;

public class ColumnPermissionRow {
    private String columnName;
    private CheckBox grant = new CheckBox();
    private CheckBox grantable = new CheckBox();


    public String getColumnName() {
        return columnName;
    }

    public CheckBox getGrant() {
        return grant;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public CheckBox getGrantable() {
        return grantable;
    }
}
