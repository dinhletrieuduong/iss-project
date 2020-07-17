package gui.dialog;

import gui.DialogBase;
import gui.entities.ColumnPermissionRow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import models.ColumnModel;
import models.PermissionModel;
import models.ViewModel;
import utils.Misc;

import java.lang.reflect.Array;
import java.net.URL;
import java.security.Permission;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ColumnPermissionDialog extends DialogBase {
    @FXML
    private TextField fieldPriv;
    @FXML
    private TableView tbvColPerm;
    private boolean isSelect;
    private String schema;
    private String table;
    private String grantee;

    public ColumnPermissionDialog(String grantee, String schema, String table, String priv) {
        super("ColumnPermissionDialog.fxml", 600, 400);
        this.isSelect = priv.equals("SELECT");
        this.fieldPriv.setText(priv);
        this.schema = schema;
        this.table = table;
        this.grantee = grantee;
        reload();
    }

    private void reload() {
        if (isSelect) {
            var model = new ColumnModel();
            var viewCols = model.getColumns(this.schema, this.table + this.grantee);
            for (var item : model.getColumns(this.schema, this.table)) {
                var row = new ColumnPermissionRow();
                row.setColumnName(item.getColumnName());
                row.getGrantable().setDisable(true);
                tbvColPerm.getItems().add(row);
                for (var col : viewCols) {
                    if (row.getColumnName() == col.getColumnName()) {
                        row.getGrant().setSelected(true);
                    }
                }
            }
            return;
        }

        var model = new ColumnModel();
        var permModel = new PermissionModel();
        var grantCol = permModel.getColumnsPermission(this.grantee, this.schema, this.table, "UPDATE");
        for (var item : model.getColumns(this.schema, this.table)) {
            var row = new ColumnPermissionRow();
            row.setColumnName(item.getColumnName());
            tbvColPerm.getItems().add(row);

            for (var col : grantCol) {
                System.out.print(col.getColName() + "=");
                System.out.println(row.getColumnName());
                if (row.getColumnName().equals(col.getColName())) {
                    row.getGrant().setSelected(true);
                    row.getGrantable().setSelected(col.isGrantable());
                }
            }
        }
    }

    @FXML
    private void updatePermission(ActionEvent e) {
        if (isSelect) {
            var model = new ViewModel();
            var listCols = new ArrayList<String>();
            for (var item : tbvColPerm.getItems()) {
                var row = (ColumnPermissionRow)item;
                if (row.getGrant().isSelected()) {
                    listCols.add(row.getColumnName());
                }
            }

            model.createViewFromTable(schema, table, table + grantee, listCols);
            var permModel = new PermissionModel();
            permModel.revoke(grantee, schema, table, "SELECT");
            permModel.grant(grantee, schema, table + grantee, "SELECT", false);
            Misc.showMsg("Update Columns Permissions", "AWESOME", "View created " + schema + "." + table + grantee);
            return;
        }

        var model = new PermissionModel();
        model.revoke(grantee, schema, table, "UPDATE");
        for (var item : tbvColPerm.getItems()) {
            var row = (ColumnPermissionRow)item;
            if (row.getGrant().isSelected()) {
                model.grantColumn(grantee, schema, table, row.getColumnName(), "UPDATE", row.getGrantable().isSelected());
            }
        }
        Misc.showMsg("Update Columns Permission", "AWESOME", "Update successfully!");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Misc.setCellValueFactory(tbvColPerm, 0, "columnName");
        Misc.setCellValueFactory(tbvColPerm, 1, "grant");
        Misc.setCellValueFactory(tbvColPerm, 2, "grantable");
    }
}
