package gui.pages;

import entities.DangKy;
import entities.SinhVien;
import gui.base.BaseControl;
import gui.dialogs.ProfileDialog;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import utils.DbConnect;
import utils.Utils;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class StudentMain extends BaseControl {
    private SinhVien sinhVien;
    @FXML
    private Label lblGender;
    @FXML
    private Label lblEmail;
    @FXML
    private Label lblAddr;
    @FXML
    private Label lblPhone;
    @FXML
    private Text txtFullname;
    @FXML
    private TableView TableGrades;
    public StudentMain(SinhVien sv) {
        super("StudentMain.fxml");
        sinhVien = sv;
        lblGender.setText((sv.getGioi_tinh() == 0 ? "Male" : "Female"));
        lblAddr.setText(sv.getDia_chi());
        lblPhone.setText(sv.getSdt());
        lblEmail.setText(sv.getEmail());
        txtFullname.setText(sv.getHo_ten() + " - " + sv.getMssv());
        reload();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Utils.setCellValueFactory(TableGrades, 0, "subjectName");
        Utils.setCellValueFactory(TableGrades, 1, "practice");
        Utils.setCellValueFactory(TableGrades, 2, "midterm");
        Utils.setCellValueFactory(TableGrades, 3, "bonus");
        Utils.setCellValueFactory(TableGrades, 4, "other");
        Utils.setCellValueFactory(TableGrades, 5, "finalG");
        Utils.setCellValueFactory(TableGrades, 6, "avg");
    }

    private void reload() {
        TableGrades.getItems().clear();
        try {
            var rs = DbConnect.executeQuery(sinhVien.getConn(), "SELECT * FROM COURSEMAN.VIEW_SINH_VIEN_DIEM");
            while (rs.next()) {
                var dk = new DangKy();
                dk.setSubjectName(rs.getString("TEN_MON_HOC"));
                dk.setPractice(rs.getFloat("DIEMTHUCHANH"));
                dk.setMidterm(rs.getFloat("DIEMGIUAKY"));
                dk.setBonus(rs.getFloat("DIEMCONG"));
                dk.setOther(rs.getFloat("DIEMKHAC"));
                dk.setFinalG(rs.getFloat("DIEMCUOIKY"));
                dk.setAvg(rs.getFloat("DIEMTRUNGBINH"));
                TableGrades.getItems().add(dk);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @FXML
    private void editProfile(){
        var dl = new ProfileDialog(sinhVien);
        dl.showAndWait();
    }
}
