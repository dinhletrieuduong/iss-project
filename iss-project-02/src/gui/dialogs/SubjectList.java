package gui.dialogs;

import entities.MonHoc;
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

public class SubjectList extends BaseControl {
    @FXML
    private TableView tableView;
    @FXML
    private Button btnAddSub, btnReload;
    private Connection connection;
    public SubjectList(Connection connection) {
        super("SubjectList.fxml");
        this.connection = connection;
        getSubjectList();
        btnAddSub.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                AddSubToMajor dialog = new AddSubToMajor(connection);
                dialog.showAndWait();
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
        Utils.setCellValueFactory(tableView, 0, "ma_mon_hoc");
        Utils.setCellValueFactory(tableView, 1, "ten_mon_hoc");
    }

    private void getSubjectList() {
        tableView.getItems().clear();
        String query = "SELECT * FROM COURSEMAN.VIEW_MON_HOC_BO_MON";
        try {
            ResultSet rs = DbConnect.executeQuery(connection, query);
            while (rs.next()) {
                MonHoc monHoc = new MonHoc();
                monHoc.setMa_mon_hoc(rs.getInt(1));
                monHoc.setTen_mon_hoc(rs.getString(3));
                tableView.getItems().add(monHoc);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
