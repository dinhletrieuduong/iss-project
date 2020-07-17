package gui;

import gui.base.BaseDialog;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import utils.DbConnect;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EditDateMaxStu extends BaseDialog {
    String tenMonHoc;
    Date ngayMo;
    int soLuong;
    @FXML
    private Label subjectLbl;
    @FXML
    private DatePicker ngayMoDatePicker;
    @FXML
    private TextField soLuongTxtFld;
    @FXML
    private Button btnUpdate;
    public EditDateMaxStu(Connection connection, int maMonHocMo, String tenMonHoc, Date ngayMo, int soLuong) {
        super("EditDateMaxStu.fxml", 500, 500);
        subjectLbl.setText(tenMonHoc);
        soLuongTxtFld.setText(soLuong + "");
        ngayMoDatePicker.setValue(ngayMo.toLocalDate());
//        ngayMoDatePicker.setPromptText(ngayMo.toString());
        btnUpdate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String query = "UPDATE COURSEMAN.VIEW_MONHOCMO_GIAOVIEN_UPDATE " +
                        "SET SO_LUONG_TOI_DA = ?, NGAY_MO = TO_DATE(?, 'yyyy/MM/dd') " +
                        "WHERE MA_MON_HOC_MO = ?";
                System.out.println(ngayMoDatePicker.getValue().toString());
                try {
                    ResultSet rs = DbConnect.executeQuery(connection, query, Integer.parseInt(soLuongTxtFld.getText()), ngayMoDatePicker.getValue().toString(), maMonHocMo);
                    rs.next();
                    close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
