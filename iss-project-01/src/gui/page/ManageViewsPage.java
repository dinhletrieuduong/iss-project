package gui.page;

import entities.Table;
import entities.User;
import entities.View;
import gui.ControlBase;
import gui.dialog.ManageTableDialog;
import gui.dialog.TablePermissionsDialog;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import models.ViewModel;
import models.UserModel;
import utils.Misc;

import java.net.URL;
import java.util.ResourceBundle;

public class ManageViewsPage extends ControlBase {
    @FXML
    private TableView tbvTables;
    @FXML
    private TableView tbvSchemas;
    @FXML
    private TextField fieldTableName;
    @FXML
    private TextField fieldSchemaName;
    @FXML
    private TextArea areaQuery;

    private String lastSchemaChoice = "";

    public ManageViewsPage() {
        super("ManageViewsPage.fxml");
        refreshSchema(null);
    }

    @FXML
    private void newTable(ActionEvent e) {
        var selectedSchema = (User)this.tbvSchemas.getSelectionModel().getSelectedItem();
        var dialog = new ManageTableDialog(selectedSchema.getUsername(), null);
        dialog.showAndWait();
        reloadTableForce();
    }

    @FXML
    private void updatePermissions(ActionEvent e) {
        var selected = tbvTables.getSelectionModel().getSelectedItem();
        if (selected != null) {
            var selectedTable = this.fieldTableName.getText();
            var selectedSchema = (User)this.tbvSchemas.getSelectionModel().getSelectedItem();
            var dialog = new TablePermissionsDialog(selectedSchema.getUsername(), selectedTable);
            dialog.showAndWait();
        }
    }

    @FXML
    private void selectItem(MouseEvent e) {
        if (e.getButton().equals(MouseButton.PRIMARY)
                && e.getClickCount() == 2) {
            updatePermissions(null);
            return;
        }

        var selected = tbvTables.getSelectionModel().getSelectedItem();
        if (selected != null) {
            var selectedTable = (View)selected;
            fieldTableName.setText(selectedTable.getName());
            areaQuery.setText(selectedTable.getText());
        } else {
            fieldTableName.setText("");
            areaQuery.setText("");
        }
    }

    @FXML
    private void deleteTable(ActionEvent e) {
//        var selected = tbvTables.getSelectionModel().getSelectedItem();
//        if (selected != null) {
//            var schema = (User)this.tbvSchemas.getSelectionModel().getSelectedItem();
//            var table = this.fieldTableName.getText();
//            var accept = Misc.showConfirmation("Delete selected table", "Becareful, you can't undo this statement!", "Do you want to delete " + table);
//            if (accept) {
//                var model = new ViewModel();
//                if (model.deleteTable(schema.getUsername(), table)) {
//                    reloadTableForce();
//                }
//            }
//        }
    }

    private void reloadTableForce() {
        var ViewModel = new ViewModel();
        this.tbvTables.getItems().clear();

        for (var table : ViewModel.getViewsInSchema(lastSchemaChoice)) {
            tbvTables.getItems().add(table);
        }
    }

    @FXML
    private void reloadTable(MouseEvent e) {
        var ViewModel = new ViewModel();
        var selectedSchema = (User)this.tbvSchemas.getSelectionModel().getSelectedItem();
        System.out.println(selectedSchema);
        System.out.println(lastSchemaChoice);
        if (selectedSchema == null) {
            fieldSchemaName.setText("");
            return;
        }

        if (!lastSchemaChoice.equals(selectedSchema.getUsername())) {
            this.tbvTables.getItems().clear();
            fieldSchemaName.setText(selectedSchema.getUsername());
            lastSchemaChoice = selectedSchema.getUsername();

            for (var table : ViewModel.getViewsInSchema(selectedSchema.getUsername())) {
                tbvTables.getItems().add(table);
            }
        }
    }

    @FXML
    private void refreshSchema(ActionEvent e) {
        var userModel = new UserModel();
        var index = 0;
        var users = userModel.getAllUsers();
        this.tbvSchemas.getItems().clear();

        for (int i = 0; i < users.size(); ++i) {
            this.tbvSchemas.getItems().add(users.get(i));
            if (users.get(i).getUsername().equals(lastSchemaChoice)) {
                index = i;
            }
        }

        if (this.tbvSchemas.getItems().size() != 0) {
            this.tbvSchemas.getSelectionModel().select(index);
            reloadTable(null);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Misc.setCellValueFactory(tbvTables, 0, "name");
        Misc.setCellValueFactory(tbvSchemas, 0, "username");
    }
}
