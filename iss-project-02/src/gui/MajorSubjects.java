package gui;

import entities.MonHoc;
import entities.MonHocMo;
import gui.base.BaseControl;
import gui.dialogs.AddSubToMajor;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import utils.DbConnect;
import utils.Utils;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MajorSubjects extends BaseControl {
    @FXML
    private TableView tableView;
    @FXML
    private Button btnReload, btnEdit;
    private Connection connection;
    public MajorSubjects(Connection connection) {
        super("MajorSubjects.fxml");
        this.connection = connection;
        getSubjectList();

        btnEdit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
//                EditDateMaxStu dialog = new EditDateMaxStu();
//                dialog.showAndWait();
            }
        });

        btnReload.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                getSubjectList();
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Utils.setCellValueFactory(tableView, 0, "ten_bo_mon");
        Utils.setCellValueFactory(tableView, 1, "ten_mon_hoc");
        Utils.setCellValueFactory(tableView, 2, "hoc_ky");
        Utils.setCellValueFactory(tableView, 3, "ngay_mo");
        Utils.setCellValueFactory(tableView, 4, "so_luong");
    }

    private void getSubjectList() {
        tableView.getItems().clear();
        String query = "SELECT * FROM COURSEMAN.VIEW_MON_HOC_MO_BO_MON";
        try {
            ResultSet rs = DbConnect.executeQuery(connection, query);
            while (rs.next()) {
                MonHocMo monHocMo = new MonHocMo();
                monHocMo.setTen_mon_hoc(rs.getString(1));
                monHocMo.setTen_bo_mon(rs.getString(2));
                monHocMo.setMa_mon_hoc_mo(rs.getInt(3));
                monHocMo.setMa_mon_hoc(rs.getInt(4));
                monHocMo.setMa_giao_vien(rs.getInt(9));
                monHocMo.setHoc_ky(rs.getInt(5));
                monHocMo.setNgay_mo(rs.getDate(6));
                monHocMo.setSo_luong(rs.getInt(7));
                monHocMo.setNgay_ket_thuc(rs.getDate(8));
                tableView.getItems().add(monHocMo);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
