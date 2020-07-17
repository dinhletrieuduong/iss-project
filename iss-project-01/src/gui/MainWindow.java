package gui;

import gui.page.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.layout.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainWindow extends BorderPane implements Initializable {
    @FXML private Tab tabTables;
    @FXML private Tab tabViews;
    @FXML private Tab tabUsers;
    @FXML private Tab tabRoles;
    @FXML private Tab tabConn;
    @FXML private Tab tabQuery;
    @FXML private Tab tabAuditing;

    public MainWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tabUsers.setContent(new ManageUsersPage());
        tabRoles.setContent(new ManageRolesPage());
        tabQuery.setContent(new QueryPage());
        tabConn.setContent(new ConnectionPage());
        tabTables.setContent(new ManageTablesPage());
        tabViews.setContent(new ManageViewsPage());
        tabAuditing.setContent(new AuditingPage());
    }
}
