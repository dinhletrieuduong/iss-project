package gui.page;

import entities.Role;
import entities.User;
import gui.ControlBase;
import gui.dialog.NewUserDialog;
import gui.dialog.UpdateRoleUserDialog;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import models.UserModel;
import utils.Misc;

import java.net.URL;
import java.util.ResourceBundle;

public class ManageUsersPage extends ControlBase {
    @FXML
    private TableView tbvUsers;

    public ManageUsersPage() {
        super("ManageUsersPage.fxml");
        refresh(null);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Misc.setCellValueFactory(tbvUsers, 0, "username");
        Misc.setCellValueFactory(tbvUsers, 1, "created");
        Misc.setCellValueFactory(tbvUsers, 2, "password");
    }

    @FXML
    private void newUser(ActionEvent e) {
        var dialog = new NewUserDialog();
        dialog.showAndWait();
        refresh(null);
    }

    @FXML
    private void delUser(ActionEvent e) {
        var user = (User)tbvUsers.getSelectionModel().getSelectedItem();
        if (user == null) {
            return;
        }

        var result = Misc.showConfirmation("Delete user", "WARNING", "Are you sure want to delete " + user.getUsername());

        if (result) {
            var model = new UserModel();
            model.deleteUser(user.getUsername());
            Misc.showMsg("Manage user", "DELETED", "User " + user.getUsername() + " has been deleted!");
            refresh(null);
        }
    }

    @FXML
    private void selectUser(MouseEvent e) {
        if (e.getButton().equals(MouseButton.PRIMARY)
                && e.getClickCount() == 2) {
            var user = (User)tbvUsers.getSelectionModel().getSelectedItem();
            if (user == null) {
                return;
            }

            var dialog = new UpdateRoleUserDialog(user.getUsername(), false);
            dialog.showAndWait();
            return;
        }
    }

    @FXML
    private void setPassword(ActionEvent e) {
        var user = (User)tbvUsers.getSelectionModel().getSelectedItem();
        if (user == null) {
            return;
        }

        var dialog = new UpdateRoleUserDialog(user.getUsername(), false);
        dialog.showAndWait();
    }

    @FXML
    private void refresh(ActionEvent e) {
        var model = new UserModel();
        tbvUsers.getItems().clear();
        for (var user : model.getAllUsers()) {
            tbvUsers.getItems().add(user);
        }
    }
}