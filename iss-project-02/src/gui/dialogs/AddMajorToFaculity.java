package gui.dialogs;

import entities.BoMon;
import gui.base.BaseDialog;
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

public class AddMajorToFaculity extends BaseDialog {
    @FXML
    private Button btnAdd;
    @FXML
    private TextField majorNameTxtFld;
    @FXML
    private ComboBox headLectureCmb;
    private Connection connection;

    public AddMajorToFaculity(Connection conn) {
        super("AddMajorToFaculity.fxml", 500, 400);
        this.connection = conn;
        getHeadLectureList();

        btnAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String tenBoMon= majorNameTxtFld.getText();
                int maTBM = Integer.parseInt(headLectureCmb.getValue().toString());
                String query = "INSERT INTO COURSEMAN.VIEW_MON_HOC_BO_MON_INSERT(MA_TBM, TEN_BO_MON) VALUES (?, ?)";

                try {
                    ResultSet rs = DbConnect.executeQuery(connection, query, maTBM, tenBoMon);
                    rs.next();
//                    query = "COMMIT";
//                    rs = DbConnect.executeQuery(giaoVien.getConn(), query);
//                    rs.next();
                    close();
                }
                catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

                System.out.println("Add");
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    private void getHeadLectureList() {
        String query = "SELECT * FROM COURSEMAN.VIEW_BO_MON_KHOA";
        try {
            ResultSet rs = DbConnect.executeQuery(connection, query);
            while (rs.next()) {
                BoMon boMon = new BoMon();
                boMon.setMa_bo_mon(rs.getInt(1));
                boMon.setMa_tbm(rs.getInt(3));
                boMon.setTenBoMon(rs.getString(4));
                headLectureCmb.getItems().add(boMon.getMa_tbm());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
