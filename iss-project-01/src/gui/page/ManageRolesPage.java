package gui.page;

import entities.Role;
import entities.User;
import gui.ControlBase;
import gui.dialog.NewRoleDialog;
import gui.dialog.UpdateRoleUserDialog;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import models.RoleModel;
import utils.Misc;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ManageRolesPage extends ControlBase {
    @FXML
    private TableView tbvRoles;

    public ManageRolesPage() {
        super("ManageRolesPage.fxml");
        reload(null);
    }

    @FXML
    private void newRole(ActionEvent e) {
        var dialog = new NewRoleDialog();
        dialog.showAndWait();
    }

    @FXML
    private void reload(ActionEvent e) {
        var model = new RoleModel();
        tbvRoles.getItems().clear();
        for (Role r : model.getAllRoles()) {
            tbvRoles.getItems().add(r);
        }
    }

    @FXML
    private void update(ActionEvent e) {
        var user = (Role)tbvRoles.getSelectionModel().getSelectedItem();
        if (user == null) {
            return;
        }

        var dialog = new UpdateRoleUserDialog(user.getRole(), true);
        dialog.showAndWait();
    }

    @FXML
    private void selectRole(MouseEvent e) {
        if (e.getButton().equals(MouseButton.PRIMARY)
                && e.getClickCount() == 2) {
            var user = (Role)tbvRoles.getSelectionModel().getSelectedItem();
            if (user == null) {
                return;
            }

            var dialog = new UpdateRoleUserDialog(user.getRole(), true);
            dialog.showAndWait();
            return;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Misc.setCellValueFactory(tbvRoles, 0, "role");
        Misc.setCellValueFactory(tbvRoles, 1, "password");
    }
}
