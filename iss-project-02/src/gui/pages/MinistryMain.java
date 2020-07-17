package gui.pages;

import entities.GiaoVu;
import entities.MonHocMo;
import gui.base.BaseControl;
import gui.dialogs.AddSubToSemYear;
import gui.dialogs.SignUpDialog;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import models.NguoiDungModel;
import utils.DbConnect;
import utils.Utils;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MinistryMain extends BaseControl {
    private GiaoVu giaoVu;
    @FXML
    private TableView tbvOpeningCourses;
    @FXML
    private TableView tbvStudents;

    public MinistryMain(GiaoVu gv) {
        super("MinistryMain.fxml");
        giaoVu = gv;
        reload();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Utils.setCellValueFactory(tbvOpeningCourses, 0, "ten_mon_hoc");
        Utils.setCellValueFactory(tbvOpeningCourses, 1, "ten_bo_mon");
        Utils.setCellValueFactory(tbvOpeningCourses, 2, "ngay_mo");
        Utils.setCellValueFactory(tbvOpeningCourses, 3, "ngay_ket_thuc");
        Utils.setCellValueFactory(tbvOpeningCourses, 4, "so_luong");

        Utils.setCellValueFactory(tbvStudents, 0, "mssv");
        Utils.setCellValueFactory(tbvStudents, 1, "ho_ten");
        Utils.setCellValueFactory(tbvStudents, 2, "email");
        Utils.setCellValueFactory(tbvStudents, 3, "sdt");
    }

    private void reload() {
        tbvOpeningCourses.getItems().clear();
        try {
            var rs = DbConnect.executeQuery(giaoVu.getConn(),
                    "SELECT bm.TEN_MON_HOC, mhm.NGAY_MO, mhm.NGAY_KET_THUC, mhm.SO_LUONG_TOI_DA, nd.HO_TEN " +
                            "FROM COURSEMAN.MON_HOC bm " +
                            "JOIN COURSEMAN.MON_HOC_MO mhm ON mhm.MA_MON_HOC = bm.MA_MON_HOC " +
                            "JOIN COURSEMAN.NGUOI_DUNG nd ON nd.MA_ND = mhm.MA_GV");
            while (rs.next()) {
                var mhm = new MonHocMo();
                mhm.setTen_mon_hoc(rs.getString("TEN_MON_HOC"));
                mhm.setNgay_mo(rs.getDate("NGAY_MO"));
                mhm.setNgay_ket_thuc(rs.getDate("NGAY_KET_THUC"));
                mhm.setSo_luong(rs.getInt("SO_LUONG_TOI_DA"));
                mhm.setTen_bo_mon(rs.getString("HO_TEN"));
                tbvOpeningCourses.getItems().add(mhm);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void reloadStudents() {
        var students = NguoiDungModel.getStudents(giaoVu.getConn());
        for (var s : students) {
            tbvStudents.getItems().add(s);
        }
    }

    @FXML
    private void openCourse(ActionEvent e) {
        var dl = new AddSubToSemYear(giaoVu);
        dl.showAndWait();
        reload();
    }

    @FXML
    private void addUser(ActionEvent e) {
        var dl = new SignUpDialog(giaoVu);
        dl.showAndWait();
        reloadStudents();
    }
}
