package gui.dialog;

import gui.DialogBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.UserModel;

import java.net.URL;
import java.util.ResourceBundle;

public class NewUserDialog extends DialogBase {
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtPassword;
    @FXML
    private Label lblMsg;

    public NewUserDialog() {
        super("NewUserDialog.fxml", 400, 200);
        this.setTitle("Create new user");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @FXML
    private void createUser(ActionEvent e) {
        var model = new UserModel();
        if (model.isUserExisted(getUsername())) {
            lblMsg.setText("User existed, please type another username");
            return;
        }

        if (getUsername().isEmpty()) {
            lblMsg.setText("Empty Username is not allowed");
            return;
        }

        model.createUser(getUsername(), getPassword());
        stage.close();
    }

    @FXML
    private void cancle() {
        stage.close();
    }

    public String getUsername() {
        return txtUsername.getText();
    }

    public String getPassword() {
        return txtPassword.getText();
    }
}
