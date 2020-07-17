package gui.dialog;

import gui.DialogBase;
import gui.entities.GrantRoleDialogRow;
import gui.entities.TablePermissionRow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import models.RoleModel;
import utils.Misc;

import java.net.URL;
import java.util.ResourceBundle;

public class GrantRoleDialog extends DialogBase {
    @FXML
    private TableView tbvRoles;
    private String username;

    public GrantRoleDialog(String username) {
        super("GrantRoleDialog.fxml", 600, 400);
        this.username = username;
        reload();
    }

    private void reload(){
        var model = new RoleModel();
        for (var grantableRole : model.getGrantableRoles(username)) {
            var row = new GrantRoleDialogRow();
            row.setRole(grantableRole);
            row.getGrant().setOnAction(this::grantChanged);
            row.getGrantable().setOnAction(this::grantChanged);
            tbvRoles.getItems().add(row);
        }
    }

    private void grantChanged(javafx.event.ActionEvent actionEvent) {
//        System.out.print(1);
        for (var item : tbvRoles.getItems()) {
            var row = (GrantRoleDialogRow)item;
            if (!row.getGrant().isSelected()) {
                row.getGrantable().setSelected(false);
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Misc.setCellValueFactory(tbvRoles, 0, "role");
        Misc.setCellValueFactory(tbvRoles, 1, "grant");
        Misc.setCellValueFactory(tbvRoles, 2, "grantable");
    }

    @FXML
    private void grant(ActionEvent e) {
        var model = new RoleModel();
        var count = 0;
        for (var item : tbvRoles.getItems()) {
            var row = (GrantRoleDialogRow)item;
            if (row.getGrant().isSelected()) {
                model.grant(username, row.getRole(), row.getGrantable().isSelected());
                count++;
            }
        }

        if (count != 0) {
            Misc.showMsg("Grant roles to user/role", "AWESOME", "Granted successfully!");
        }
    }
}
