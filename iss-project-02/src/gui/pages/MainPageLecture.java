package gui.pages;

import entities.GiaoVien;
import gui.Subject;
import gui.SubjectAvailable;
import gui.dialogs.ScheduleofLecturer;
import gui.dialogs.SubjectList;
import gui.base.BaseControl;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import utils.DbConnect;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MainPageLecture extends BaseControl {
    private GiaoVien giaoVien;
    @FXML
    private AnchorPane subjectList, subAvailList, scheduleList;
    public MainPageLecture(GiaoVien giaoVien) {
        super("MainPageLecture.fxml");
        this.giaoVien = giaoVien;
        loadSubjectList();
        loadSubjectAvailabelList();
        loadScheduleList();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void loadSubjectList() {
        subjectList.getChildren().add(new Subject(giaoVien.getConn()));
    }

    private void loadSubjectAvailabelList() {
        subAvailList.getChildren().add(new SubjectAvailable(giaoVien.getConn()));
    }
    public void loadScheduleList() {
        scheduleList.getChildren().add(new ScheduleofLecturer(giaoVien.getConn()));
    }
}
