package gui.dialogs;

import entities.GiaoVien;
import entities.LichHoc;
import gui.base.BaseControl;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import utils.DbConnect;
import utils.Utils;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ScheduleofLecturer extends BaseControl {
    private Connection connection;
    @FXML
    private TableView tableView;

    public ScheduleofLecturer(Connection connection) {
        super("ScheduleofLecturer.fxml");
        this.connection = connection;
        getScheduleList();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Utils.setCellValueFactory(tableView, 0, "ma_mon_hoc_mo");
        Utils.setCellValueFactory(tableView, 1, "ten_mon_hoc");
        Utils.setCellValueFactory(tableView, 2, "thu_trong_tuan");
        Utils.setCellValueFactory(tableView, 3, "ca_bat_dau");
        Utils.setCellValueFactory(tableView, 4, "ca_ket_thuc");
    }

    private void getScheduleList() {
        String query = "SELECT * FROM COURSEMAN.VIEW_LICH_MON_HOC";
        try {
            ResultSet rs = DbConnect.executeQuery(connection, query);
            while (rs.next()) {
                LichHoc lichHoc = new LichHoc();
                lichHoc.setTen_mon_hoc(rs.getString(1));
                lichHoc.setMa_mon_hoc_mo(rs.getInt(2));
                lichHoc.setThu_trong_tuan(rs.getInt(3));
                lichHoc.setCa_bat_dau(rs.getInt(4));
                lichHoc.setCa_ket_thuc(rs.getInt(5));
                tableView.getItems().add(lichHoc);
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
