package gui.dialogs;

import entities.NguoiDung;
import gui.base.BaseDialog;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ProfileDialog extends BaseDialog {
    private NguoiDung nguoiDung;
    @FXML
    private TextField txtfieldUsername;
    @FXML
    private TextField txtfieldFullname;
    @FXML
    private TextField txtfieldEmail;
    @FXML
    private TextField txtfieldAddr;
    @FXML
    private TextField txtfieldPhone;
    @FXML
    private TextField txtfieldDob;
    @FXML
    private TextField txtfieldSex;
    public ProfileDialog(NguoiDung nd) {
        super("ProfileDialog.fxml", 760, 607);
        setResizable(false);
        nguoiDung = nd;
        txtfieldAddr.setText(nguoiDung.getDia_chi());
        txtfieldDob.setText(nguoiDung.getNgay_sinh().toString());
        txtfieldEmail.setText(nguoiDung.getEmail());
        txtfieldFullname.setText(nguoiDung.getHo_ten());
        txtfieldPhone.setText(nguoiDung.getSdt());
        txtfieldSex.setText((nguoiDung.getGioi_tinh() == 0 ? "Male" : "Female"));
        txtfieldUsername.setText(nguoiDung.getUsername().substring(3));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
