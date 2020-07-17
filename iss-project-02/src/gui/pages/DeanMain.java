package gui.pages;

import entities.GiaoVien;
import gui.MajorSubjects;
import gui.dialogs.MajorDialog;
import gui.base.BaseControl;
import gui.dialogs.ScheduleofLecturer;
import gui.dialogs.SubjectList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import utils.DbConnect;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DeanMain extends BaseControl {
    private GiaoVien giaoVien;
    @FXML
    private AnchorPane subjectList, majorList, scheduleList;
    @FXML
    private Tab subjectTab, majorTab, scheduleTab;
    @FXML
    private TabPane tabPane;
    @FXML
    private Label textKhoa;
    public DeanMain(GiaoVien giaoVien) {
        super("DeanMain.fxml");
        this.giaoVien = giaoVien;
        var sql = "SELECT TEN_KHOA FROM COURSEMAN.KHOA " +
                "WHERE MA_TPK = (SELECT MA_ND FROM " +
                "COURSEMAN.NGUOI_DUNG)";
        try {
            var rs = DbConnect.executeQuery(giaoVien.getConn(), sql);
            if (rs.next()) {
                textKhoa.setText(rs.getString("TEN_KHOA"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        loadMajorList();
        loadSubjectList();
        loadScheduleList();
//
//        subjectTab.setOnSelectionChanged(new EventHandler<Event>() {
//            @Override
//            public void handle(Event event) {
//                System.out.println(tabPane.getSelectionModel().getSelectedItem().getText());
//            }
//        });
//        majorTab.setOnSelectionChanged(new EventHandler<Event>() {
//            @Override
//            public void handle(Event event) {
//                System.out.println(tabPane.getSelectionModel().getSelectedItem().getText());
//            }
//        });

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void loadMajorList() {
        majorList.getChildren().add(new MajorDialog(giaoVien.getConn()));
    }
    public void loadSubjectList() {
        subjectList.getChildren().add(new SubjectList(giaoVien.getConn()));
    }
    public void loadScheduleList() {
        scheduleList.getChildren().add(new ScheduleofLecturer(giaoVien.getConn()));
    }
}
