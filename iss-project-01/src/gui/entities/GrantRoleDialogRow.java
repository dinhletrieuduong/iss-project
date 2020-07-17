package gui.entities;

import javafx.scene.control.CheckBox;

public class GrantRoleDialogRow {
    private String role;
    private CheckBox grant = new CheckBox();
    private CheckBox grantable = new CheckBox();

    public CheckBox getGrant() {
        return grant;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public CheckBox getGrantable() {
        return grantable;
    }
}
