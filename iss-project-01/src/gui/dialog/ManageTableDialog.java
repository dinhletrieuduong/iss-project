package gui.dialog;

import entities.Column;
import gui.DialogBase;
import gui.entities.ManageTableRow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import models.ColumnModel;
import models.TableModel;
import utils.Misc;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ManageTableDialog extends DialogBase {
    @FXML
    private TableView tbvAttributes;
    @FXML
    private TextField fieldTableName;
    private String schema;
    private String table;

    public ManageTableDialog(String schema, String table) {
        super("ManageTableDialog.fxml", 1000, 600);
        this.setTitle("Manage Table");
        this.schema = schema;
        this.table = table;
    }

    @FXML
    private void newAttribute(ActionEvent e) {
        tbvAttributes.getItems().add(new ManageTableRow());
    }

    @FXML
    private void deleteAttribute(ActionEvent e) {
        var indices = tbvAttributes.getSelectionModel().getSelectedIndices();
        for (int i = indices.size() - 1; i >= 0; --i) {
            int index = (int)indices.get(i);
            tbvAttributes.getItems().remove(index);
        }
    }

    private boolean newTable() {
        if (fieldTableName.getText().isBlank()) {
//            Misc.showMsg("Manage Table", "ERROR", "Error, Blank table name is not allowed!");
            fieldTableName.requestFocus();
            return false;
        }

        var listCol = new ArrayList<Column>();

        for (var item : tbvAttributes.getItems()) {
            var row = (ManageTableRow)item;
            var colname = row.getColumnName().getText();
            var type = (String)row.getAttrType().getSelectionModel().getSelectedItem();
            var nullable = row.getNullable().isSelected();

            if (colname.isBlank()) {
                row.getColumnName().requestFocus();
                break;
            }

            listCol.add(new Column(colname, type, nullable));
        }

        if (listCol.size() != 0) {
            var model = new TableModel();
            var success = model.createTable(schema, fieldTableName.getText(), listCol);
            if (!success) {
                Misc.showMsg("Manage Table", "ERROR", "An error occurred while creating new table");
                return false;
            }
            return true;
        }

        return false;
    }

    private void loadTable() {
        var model = new ColumnModel();
        for (var col : model.getColumns(this.schema, this.table)) {
            System.out.println(col.getColumnName());
            tbvAttributes.getItems().add(new ManageTableRow(col));
        }
    }

    private void updateTable() {

    }

    @FXML
    private void submitChanges(ActionEvent e){
        if (table == null || table.equals("")) {
            if (newTable()) {
                Misc.showMsg("Create new table", "AWESOME", "Create new table successfully");
                this.stage.close();
            }
        } else {
            updateTable();
        }
    }

    @Override
    protected void loadBeforeShow() {
        if (this.table == null || this.table.equals("")) {
            newAttribute(null);
        } else {
            loadTable();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tbvAttributes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        Misc.setCellValueFactory(tbvAttributes, 0, "columnName");
        Misc.setCellValueFactory(tbvAttributes, 1, "attrType");
        Misc.setCellValueFactory(tbvAttributes, 2, "nullable");
    }
}
