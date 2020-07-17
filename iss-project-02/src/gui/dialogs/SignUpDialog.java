package gui.dialogs;

import entities.GiaoVu;
import gui.MsgBox;
import gui.base.BaseDialog;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import utils.DbConnect;

import java.net.URL;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ResourceBundle;

public class SignUpDialog extends BaseDialog {
    private GiaoVu giaoVu;
    @FXML
    private TextField fieldUsername;
    @FXML
    private PasswordField fieldPassword;
    @FXML
    private TextField fieldFullname;
    @FXML
    private TextField fieldEmail;
    @FXML
    private TextField fieldAddr;
    @FXML
    private TextField fieldPhone;
    @FXML
    private DatePicker fieldDob;
    @FXML
    private RadioButton rbFemale;
    @FXML
    private RadioButton rbMale;
    @FXML
    private RadioButton selectStudent;
    @FXML
    private RadioButton selectLecturer;
    @FXML
    private TextField fieldID;
    @FXML
    private ComboBox cbDean;

    public SignUpDialog(GiaoVu gv) {
        super("SignUpDialog.fxml", 760, 607);
        giaoVu = gv;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void changeKieuND(ActionEvent e) {
        if (selectStudent.isSelected()) {
            fieldID.setDisable(false);
            cbDean.setDisable(false);
            fieldUsername.setDisable(true);
        } else {
            fieldUsername.setDisable(false);
            fieldID.setDisable(true);
            cbDean.setDisable(true);
        }
    }

    @FXML
    private void signUp(ActionEvent e) {
        var username = fieldUsername.getText();
        var password = fieldPassword.getText();
        var email = fieldEmail.getText();
        var dob = Date.valueOf(fieldDob.getValue().toString());
        var addr = fieldAddr.getText();
        var phone = fieldPhone.getText();
        var fullname = fieldFullname.getText();
        var sex = rbMale.isSelected() ? 0 : 1;

        if (selectStudent.isSelected()) {
            var id = fieldID.getText();
            username = id;
            var dean = 1;
            try {
                DbConnect.callProcedure(giaoVu.getConn(),
                    "COURSEMAN.sp_RegisterUser(?, ?, ?, ?, ?, ?, ?, ?, ?, null, ?, 3)",
                    username, password, fullname, sex, addr, phone, dob, email, dean, id);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        MsgBox.showSuccessMsg("Create new User", "Create user successfully!");
    }
}
