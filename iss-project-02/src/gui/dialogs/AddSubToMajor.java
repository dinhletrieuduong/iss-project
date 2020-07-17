package gui.dialogs;

import entities.BoMon;
import entities.GiaoVien;
import gui.base.BaseDialog;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import utils.DbConnect;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddSubToMajor extends BaseDialog {
    @FXML
    private Button btnAdd;
    @FXML
    private TextField subNameTxtFld;
    @FXML
    private ComboBox comboBox;

    private Connection connection;

    public AddSubToMajor(Connection connection) {
        super("AddSubToMajor.fxml", 500, 400);
        this.connection = connection;
        getMajorList();
        btnAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String tenMonHoc= subNameTxtFld.getText();
                int maBoMon = Integer.parseInt(comboBox.getValue().toString().split(" ")[0]);
                String query = "INSERT INTO COURSEMAN.VIEW_MON_HOC_BO_MON_INSERT(MA_BO_MON, TEN_MON_HOC) VALUES (?, ?)";

                try {
                    ResultSet rs = DbConnect.executeQuery(connection, query, maBoMon, tenMonHoc);
                    rs.next();
//                    query = "COMMIT";
//                    rs = DbConnect.executeQuery(giaoVien.getConn(), query);
//                    rs.next();
                    close();
                }
                catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private void getMajorList() {
        String query = "SELECT * FROM COURSEMAN.VIEW_BO_MON_KHOA";
        try {
            ResultSet rs = DbConnect.executeQuery(connection, query);
            while (rs.next()) {
                BoMon boMon = new BoMon();
                boMon.setMa_bo_mon(rs.getInt(1));
                boMon.setTenBoMon(rs.getString(4));
                comboBox.getItems().add(boMon.getMa_bo_mon() + " - " + boMon.getTenBoMon());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
