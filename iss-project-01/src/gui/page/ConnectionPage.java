package gui.page;

import gui.ControlBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import utils.Config;
import utils.DbConnect;

import java.net.URL;
import java.util.ResourceBundle;

public class ConnectionPage extends ControlBase {
    @FXML private TextField txtUsername;
    @FXML private TextField txtPassword;
    @FXML private Label lblMsg;

    @FXML private TextField txtCnnUsername;
    @FXML private TextField txtCnnPassword;
    @FXML private TextField txtCnnHost;
    @FXML private TextField txtCnnPort;

    public ConnectionPage() {
        super("ConnectionPage.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtCnnHost.setText(Config.getHost());
        txtCnnPort.setText(Config.getPort());
        txtCnnUsername.setText(Config.getUsername());
        txtCnnPassword.setText(Config.getPassword());
    }

    @FXML
    private void btnSave_OnAction(ActionEvent e) {
        Config.setHost(txtCnnHost.getText());
        Config.setPort(txtCnnPort.getText());
        Config.setUsername(txtCnnUsername.getText());
        Config.setPassword(txtCnnPassword.getText());
        Config.save();
    }

    @FXML
    private void btnLogin_OnAction(ActionEvent e) {
        String msg = DbConnect.testLogin(txtUsername.getText(), txtPassword.getText());
        if (msg == null) {
            lblMsg.setText("Succeed");
        } else {
            lblMsg.setText("Failed: " + msg);
        }
    }
}
