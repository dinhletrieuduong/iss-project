package gui.dialogs;

import entities.GiaoVu;
import gui.MsgBox;
import gui.base.BaseDialog;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import models.MonHocModel;
import models.NguoiDungModel;
import utils.DbConnect;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddSubToSemYear extends BaseDialog {
    @FXML
    private ComboBox cbMonHoc;
    @FXML
    private ComboBox cbLecturer;
    @FXML
    private DatePicker dpStart;
    @FXML
    private DatePicker dpEnd;
    @FXML
    private TextField fieldNumber;
    private GiaoVu giaoVu;

    public AddSubToSemYear(GiaoVu giaovu) {
        super("AddSubToSemYear.fxml", 501, 567);
        giaoVu = giaovu;
        reload();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private void reload() {
        var res = MonHocModel.getSubjects(giaoVu.getConn());
        for (var item : res) {
            cbMonHoc.getItems().add(item.getMa_mon_hoc() + "-" + item.getTen_mon_hoc());
        }

        var gvs = NguoiDungModel.getLecturer(giaoVu.getConn());
        for (var item : gvs) {
            cbLecturer.getItems().add(item.getMa_nd() + "-" + item.getHo_ten());
        }
    }

    private String parseID(String str) {
        return str.substring(0, str.indexOf('-'));
    }

    @FXML
    private void addCourse(ActionEvent e) {
        var selected = cbMonHoc.getSelectionModel().getSelectedItem();
        var selected2 = cbLecturer.getSelectionModel().getSelectedItem();
        if (selected != null) {
            var id = parseID(selected.toString());
            var idgv = parseID(selected2.toString());
            var startDate = Date.valueOf(dpStart.getValue().toString());
            var endDate = Date.valueOf(dpEnd.getValue().toString());
            var number = fieldNumber.getText();

            try {
                DbConnect.executeUpdate(giaoVu.getConn(), "INSERT INTO COURSEMAN.MON_HOC_MO(MA_MON_HOC, HOC_KY, NGAY_MO, SO_LUONG_TOI_DA," +
                        "NGAY_KET_THUC, MA_GV) " +
                        "VALUES (?, 2, ?, ?, ?, ?)",
                        id, startDate, number, endDate, idgv);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            MsgBox.showSuccessMsg("Open new course", "Open new course successfully!");
        }
    }
}
