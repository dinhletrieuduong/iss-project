package gui;

import entities.MonHocMo;
import gui.base.BaseControl;
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

public class SubjectAvailable extends BaseControl {
    private Connection connection;
    @FXML
    private TableView<MonHocMo> tableView;
    @FXML
    private Button btnReload, btnEdit;
    public SubjectAvailable(Connection connection) {
        super("SubjectAvailable.fxml");
        this.connection = connection;
        getSubjectAvailableList();

        btnEdit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (tableView.getSelectionModel().getSelectedItem() != null) {
                    MonHocMo monHocMo = tableView.getSelectionModel().getSelectedItem();
                    System.out.println(monHocMo.getTen_mon_hoc());
                    EditDateMaxStu dialog = new EditDateMaxStu(connection, monHocMo.getMa_mon_hoc_mo(), monHocMo.getTen_mon_hoc(), monHocMo.getNgay_mo(), monHocMo.getSo_luong());
                    dialog.showAndWait();
                }
            }
        });
        btnReload.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                getSubjectAvailableList();
            }
        });
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Utils.setCellValueFactory(tableView, 0, "ma_mon_hoc");
        Utils.setCellValueFactory(tableView, 1, "ten_mon_hoc");
        Utils.setCellValueFactory(tableView, 2, "hoc_ky");
        Utils.setCellValueFactory(tableView, 3, "so_luong");
        Utils.setCellValueFactory(tableView, 4, "ngay_mo");
        Utils.setCellValueFactory(tableView, 5, "ngay_ket_thuc");
    }

    private void getSubjectAvailableList() {
        tableView.getItems().clear();
        String query = "SELECT * FROM COURSEMAN.VIEW_MON_HOC_MO_GIAO_VIEN";
        try {
            ResultSet rs = DbConnect.executeQuery(connection, query);
            while (rs.next()) {
                MonHocMo monHocMo = new MonHocMo();
                monHocMo.setTen_mon_hoc(rs.getString(1));
                monHocMo.setMa_mon_hoc_mo(rs.getInt(2));
                monHocMo.setMa_mon_hoc(rs.getInt(3));
                monHocMo.setMa_giao_vien(rs.getInt(8));
                monHocMo.setHoc_ky(rs.getInt(4));
                monHocMo.setNgay_mo(rs.getDate(5));
                monHocMo.setSo_luong(rs.getInt(6));
                monHocMo.setNgay_ket_thuc(rs.getDate(7));
                tableView.getItems().add(monHocMo);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
