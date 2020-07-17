package gui.dialogs;

import entities.BoMon;
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

public class MajorDialog extends BaseControl {
    @FXML
    private TableView tableView;
    @FXML
    private Button btnAddMajor, btnReload;
    private Connection connection;
    public MajorDialog(Connection connection) {
        super("MajorDialog.fxml");
        this.connection = connection;
        getMajorList();
        btnAddMajor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                AddMajorToFaculity dialog = new AddMajorToFaculity(connection);
                dialog.showAndWait();
            }
        });

        btnReload.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                getMajorList();
            }
        });

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Utils.setCellValueFactory(tableView, 0, "ma_bo_mon");
        Utils.setCellValueFactory(tableView, 1, "ma_tbm");
        Utils.setCellValueFactory(tableView, 2, "tenBoMon");
    }

    private void getMajorList() {
        tableView.getItems().clear();
        String query = "SELECT * FROM COURSEMAN.VIEW_BO_MON_KHOA";
        try {
            ResultSet rs = DbConnect.executeQuery(connection, query);
            while (rs.next()) {
                BoMon boMon = new BoMon();
                boMon.setMa_bo_mon(rs.getInt(1));
//                boMon.setMa_khoa(rs.getInt(2));
                boMon.setMa_tbm(rs.getInt(3));
                boMon.setTenBoMon(rs.getString(4));
                tableView.getItems().add(boMon);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
