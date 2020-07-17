package gui.page;

import gui.ControlBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import utils.DbConnect;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class QueryPage extends ControlBase {
    @FXML
    private TextArea areaQuery;
    public QueryPage() {
        super("QueryPage.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void runQuery(ActionEvent e) {
        var text = areaQuery.getText().replace("\n", " ");
        try {
            System.out.println(text);
            DbConnect.executeQuery(text);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
