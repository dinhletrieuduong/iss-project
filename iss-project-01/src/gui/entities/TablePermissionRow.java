package gui.entities;

import javafx.scene.control.CheckBox;

public class TablePermissionRow {
    private String permission;
    private String grantor;
    private CheckBox grant = new CheckBox();
    private CheckBox grantable = new CheckBox();

    public TablePermissionRow(String permission, String grantor) {
        this.permission = permission;
        this.grantor = grantor;
    }

    public String getPermission() {
        return permission;
    }

    public String getGrantor() {
        return grantor;
    }

    public void setGrantor(String value) { grantor = value; }

    public CheckBox getGrant() {
        return grant;
    }

    public CheckBox getGrantable() {
        return grantable;
    }
}
