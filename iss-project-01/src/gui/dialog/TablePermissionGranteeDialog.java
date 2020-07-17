package gui.dialog;

import entities.TableGrantee;
import gui.DialogBase;
import gui.entities.TablePermissionGranteeRow;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import models.PermissionModel;
import utils.Misc;

import java.net.URL;
import java.util.ResourceBundle;

public class TablePermissionGranteeDialog extends DialogBase {
    @FXML
    private TableView tbvGrantees;
    private String schema;
    private String table;
    public TablePermissionGranteeDialog(String schema, String table) {
        super("TablePermissionGranteeDialog.fxml", 600, 300);
        this.table = table;
        this.schema = schema;
        reload();
    }

    private void reload() {
        var model = new PermissionModel();
        for (TableGrantee grantee : model.getTableNonGratees(schema, table)) {
//            System.out.println(grantee.getGrantee());
            var row = new TablePermissionGranteeRow();
            row.setGrantee(grantee.getGrantee());
            tbvGrantees.getItems().add(row);
        }
    }

    @FXML
    private void grantSelect() {
        var model = new PermissionModel();
        for (var item : tbvGrantees.getItems()) {
            var row = (TablePermissionGranteeRow)item;
            if (row.getSelect().isSelected()) {
                model.grant(row.getGrantee(), schema, table, "SELECT", false);
            }
        }

        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Misc.setCellValueFactory(tbvGrantees, 0, "grantee");
        Misc.setCellValueFactory(tbvGrantees, 1, "select");
    }
}
