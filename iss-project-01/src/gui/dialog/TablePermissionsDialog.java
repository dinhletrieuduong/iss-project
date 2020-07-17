package gui.dialog;

import entities.TableGrantee;
import entities.TablePermission;
import gui.DialogBase;
import gui.entities.TablePermissionRow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import models.PermissionModel;
import models.TableModel;
import utils.DbConnect;
import utils.Misc;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class TablePermissionsDialog extends DialogBase {
    @FXML
    private TextField fieldSchema;
    @FXML
    private TextField fieldTableName;
    @FXML
    private TableView tbvUsers;
    @FXML
    private TableView tbvPermissions;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnColumnPermissions;

    public TablePermissionsDialog(String schema, String table) {
        super("TablePermissionsDialog.fxml", 1000, 600);
        setResizable(true);
        fieldSchema.setText(schema);
        fieldTableName.setText(table);
        reloadGrantees();

        String permissions[] = {"SELECT", "INSERT", "DELETE", "UPDATE"};
        for (var s : permissions) {
            var row = new TablePermissionRow(s, "");
            row.getGrant().setOnAction(this::grantChanged);
            row.getGrantable().setOnAction(this::grantChanged);
            tbvPermissions.getItems().add(row);
        }

        setDisabled2(true);
    }

    private void grantChanged(javafx.event.ActionEvent actionEvent) {
//        System.out.print(1);
        for (var item : tbvPermissions.getItems()) {
            var row = (TablePermissionRow)item;
            if (!row.getGrant().isSelected()) {
                row.getGrantable().setSelected(false);
            }
        }
    }

    @FXML
    private void changeColPerms(ActionEvent e) {
        var priv = (TablePermissionRow)tbvPermissions.getSelectionModel().getSelectedItem();
        var grantee = (TableGrantee)tbvUsers.getSelectionModel().getSelectedItem();
        var dialog = new ColumnPermissionDialog(grantee.getGrantee(),
                fieldSchema.getText(), fieldTableName.getText(), priv.getPermission());
        dialog.showAndWait();
    }

    @FXML
    private void addGrantee(ActionEvent e) {
        var dialog = new TablePermissionGranteeDialog(fieldSchema.getText(), fieldTableName.getText());
        dialog.showAndWait();
        reloadGrantees();
    }

    @FXML
    private void updateTablePermissions(ActionEvent e) {
        var grantee = (TableGrantee)tbvUsers.getSelectionModel().getSelectedItem();
        var model = new PermissionModel();
        for (var item : tbvPermissions.getItems()) {
            var row = (TablePermissionRow)item;
            if (row.getGrant().isSelected()) {
                model.grant(grantee.getGrantee(),
                    fieldSchema.getText(),
                    fieldTableName.getText(),
                    row.getPermission(),
                    row.getGrantable().isSelected());
            } else {
                model.revoke(grantee.getGrantee(),
                    fieldSchema.getText(),
                    fieldTableName.getText(),
                    row.getPermission());
            }
        }

        Misc.showMsg("Manage table permissions", "AWESOME", "Update permissions successfully!");
    }

    private void setDisabled2(boolean disabled) {
        for (var item : tbvPermissions.getItems()) {
            var row = (TablePermissionRow) item;
            row.getGrant().setDisable(disabled);
            row.getGrantable().setDisable(disabled);
        }

        btnUpdate.setDisable(disabled);
    }

    @FXML
    private void selectPermission(MouseEvent e) {
        var perm = (TablePermissionRow)tbvPermissions.getSelectionModel().getSelectedItem();
        var grantee = (TableGrantee)tbvUsers.getSelectionModel().getSelectedItem();
        if (perm == null) {
            return;
        }

        if (perm.getPermission() == "SELECT" ||
            perm.getPermission() == "UPDATE") {
            btnColumnPermissions.setDisable(false);
        } else {
            btnColumnPermissions.setDisable(true && (grantee != null));
        }
    }

    @FXML
    private void selectGrantee(MouseEvent e) {
        var grantee = (TableGrantee)tbvUsers.getSelectionModel().getSelectedItem();
        if (grantee == null) {
            setDisabled2(true);
            return;
        }

        loadPermissions(grantee.getGrantee());
        setDisabled2(false);
    }

    @FXML
    private void revokeAllFromGrantee(ActionEvent e) {
        var grantee = (TableGrantee)tbvUsers.getSelectionModel().getSelectedItem();
        if (grantee == null) {
            return;
        }

        var model = new PermissionModel();
        model.revoke(grantee.getGrantee(), fieldSchema.getText(), fieldTableName.getText(), "ALL");
        reloadGrantees();
    }

    private void reloadGrantees() {
        var model = new PermissionModel();
        var results = model.getTableGrantees(fieldSchema.getText(), fieldTableName.getText());
        tbvUsers.getItems().clear();
        for (var r : results) {
            tbvUsers.getItems().add(r);
        }
    }

    private void loadPermissions(String grantee) {
        var model = new PermissionModel();
        var tabperms = model.getTablePermissions(grantee, fieldSchema.getText(), fieldTableName.getText());
        for (var item : tbvPermissions.getItems()) {
            var row = (TablePermissionRow)item;
            row.setGrantor("");
            row.getGrantable().setSelected(false);
            row.getGrant().setSelected(false);
            for (var p : tabperms) {
                if (row.getPermission().equals(p.getPrivilege())) {
                    row.setGrantor(p.getGrantor());
                    row.getGrant().setSelected(true);
                    row.getGrantable().setSelected(p.isGrantable());
                }
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Misc.setCellValueFactory(tbvUsers, 0, "grantee");
        Misc.setCellValueFactory(tbvPermissions, 0, "permission");
        Misc.setCellValueFactory(tbvPermissions, 1, "grantor");
        Misc.setCellValueFactory(tbvPermissions, 2, "grant");
        Misc.setCellValueFactory(tbvPermissions, 3, "grantable");
    }
}
