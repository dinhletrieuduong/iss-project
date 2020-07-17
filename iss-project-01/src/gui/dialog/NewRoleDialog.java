package gui.dialog;
import gui.DialogBase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.RoleModel;
import utils.Misc;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NewRoleDialog extends DialogBase {
    @FXML
    private TextField txtRolename;
    @FXML
    private TextField txtPassword;
    @FXML
    private Label lblMsg;

    public NewRoleDialog() {
        super("NewRoleDialog.fxml", 600, 400);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void btnCancle_OnAction(ActionEvent e) {
        stage.close();
    }

    @FXML
    private void btnCreate_OnAction(ActionEvent e) {
        var model = new RoleModel();
        if (model.isRoleExisted(getRole())) {
            lblMsg.setText("Role existed, please type another role");
            return;
        }

        if (getRole().isEmpty()) {
            lblMsg.setText("Empty Role is not allowed");
            return;
        }


        model.createRole(getRole(), getPassword());
        Misc.showMsg("Create new role", "AWESOME", "Create role successfully!");
        stage.close();
    }

    public String getRole() {
        return txtRolename.getText();
    }

    public String getPassword() {
        return txtPassword.getText();
    }
}
