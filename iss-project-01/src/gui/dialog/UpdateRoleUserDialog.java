package gui.dialog;

import entities.GrantedRole;
import gui.DialogBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.RoleModel;
import models.UserModel;
import utils.Misc;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UpdateRoleUserDialog extends DialogBase {
    @FXML
    private TextField fieldPasswd;
    @FXML
    private TableView tbvGrantedRoles;
    private String username;
    private boolean isRole;
    public UpdateRoleUserDialog(String username, boolean isRole) {
        super("UpdateRoleUserDialog.fxml", 800, 400);
        this.username = username;
        this.isRole = isRole;
        reload();
    }

    public void reload() {
        var model = new RoleModel();
        tbvGrantedRoles.getItems().clear();
        for (var role : model.getGrantedRoles(username)) {
            tbvGrantedRoles.getItems().add(role);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Misc.setCellValueFactory(tbvGrantedRoles, 0, "role");
        Misc.setCellValueFactory(tbvGrantedRoles, 1, "grantOption");
    }

    @FXML
    private void grant(ActionEvent e) {
        var dialog = new GrantRoleDialog(username);
        dialog.showAndWait();
        reload();
    }

    @FXML
    private void revoke(ActionEvent e) {
        var role = (GrantedRole)tbvGrantedRoles.getSelectionModel().getSelectedItem();
        if (role != null) {
            var result = Misc.showConfirmation("Revoke role", "WARNING", "Are you sure want to revoke role " + role.getRole());
            if (!result) {return;}
            var model = new RoleModel();
            model.revoke(username, role.getRole());
            reload();
        }
    }

    @FXML
    private void update(ActionEvent e) {
        var model = new RoleModel();
        if (!fieldPasswd.getText().isBlank()) {
            if (isRole) {
                model.setRolePassword(username, fieldPasswd.getText());
            } else {
                var umodel = new UserModel();
                umodel.setUserPassword(username, fieldPasswd.getText());
            }
            Misc.showMsg("Update user/role password", "AWESOME", "User password changed!");
        }
    }
}
