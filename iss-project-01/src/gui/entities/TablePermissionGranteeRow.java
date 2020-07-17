package gui.entities;

import javafx.scene.control.CheckBox;

public class TablePermissionGranteeRow {
    private String grantee;
    private CheckBox select = new CheckBox();

    public String getGrantee() {
        return grantee;
    }

    public CheckBox getSelect() {
        return select;
    }

    public void setGrantee(String grantee) {
        this.grantee = grantee;
    }
}
