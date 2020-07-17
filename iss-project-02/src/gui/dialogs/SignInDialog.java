package gui.dialogs;

import entities.GiaoVien;
import entities.GiaoVu;
import entities.NguoiDung;
import entities.SinhVien;
import gui.MsgBox;
import gui.base.BaseControl;
import gui.base.BaseDialog;
import gui.pages.DeanMain;
import gui.pages.MainPageLecture;
import gui.pages.MinistryMain;
import gui.pages.StudentMain;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import models.NguoiDungModel;

import java.net.URL;
import java.util.ResourceBundle;

public class SignInDialog extends BaseDialog {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    private NguoiDung user;

    public SignInDialog() {
        super("SignInDialog.fxml", 800, 400);
        setResizable(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public BaseControl routeMainPage() {
        var type = user.getType();
        BaseControl mainPage = null;

        switch (type) {
            case 1:
                mainPage = new MinistryMain((GiaoVu)user);
                break;
            case 2:
                if (((GiaoVien)user).getKieugv() == 0)
                    mainPage = new DeanMain((GiaoVien)user);
//                else if (((GiaoVien)user).getKieugv() == 1)
//                    mainPage = new MainPageLecture((GiaoVien)user);
                else
                    mainPage = new MainPageLecture((GiaoVien)user);

                break;
            case 3:
                mainPage = new StudentMain((SinhVien)user);
                break;
            default:
                MsgBox.showError("Error occurred", "Something went wrong, please contact us via phone +84854356665");
                break;
        }
        return mainPage;
    }

    @FXML
    private void signIn(ActionEvent e) {
        user = NguoiDungModel.signIn(username.getText(), password.getText());
        if (user == null) {
            MsgBox.showError("Login failed", "Wrong username or password");
            return;
        }
        close();
    }
}
