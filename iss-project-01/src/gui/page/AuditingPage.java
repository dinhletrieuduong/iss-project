package gui.page;

import entities.Auditing;
import gui.ControlBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import models.AuditingModel;
import utils.DbConnect;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AuditingPage extends ControlBase
{
    @FXML
    private TableView<Auditing> nhatkitable;

    @FXML
    private TableColumn<Auditing, String> usernameCol;

    @FXML
    private TableColumn<Auditing, String> ownerCol;

    @FXML
    private TableColumn<Auditing, String> object_nameCol;

    @FXML
    private TableColumn<Auditing, String> actionCol;

    @FXML
    private TableColumn<Auditing, String> sql_textCol;

    @FXML
    private TextField UserText;

    @FXML
    private TextField TableText;
    
    public AuditingPage()
    {
        super("AuditingPage.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        usernameCol.setCellValueFactory( new PropertyValueFactory<Auditing, String>("username"));
        ownerCol.setCellValueFactory( new PropertyValueFactory<Auditing, String>("owner"));
        object_nameCol.setCellValueFactory( new PropertyValueFactory<Auditing, String>("object_name"));
        actionCol.setCellValueFactory( new PropertyValueFactory<Auditing, String>("action"));
        sql_textCol.setCellValueFactory( new PropertyValueFactory<Auditing, String>("sql_text"));

        reload();
    }

    public void reload ()
    {
        nhatkitable.getItems().clear();
        AuditingModel Auditingmodel = new AuditingModel();
        ArrayList<Auditing> Auditing = Auditingmodel.GetAllAuditing();
        for (int i = 0 ; i < Auditing.size(); ++i)
        {
            nhatkitable.getItems().add(Auditing.get(i));
        }
    }

    public void disableAuditing(ActionEvent e)
    {
        try
        {
            DbConnect.executeUpdate("NOAUDIT ALL");
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }

    public void EnableAuditUser(ActionEvent e)
    {
        if(CheckCondition()==0)
            return;

        try
        {
            DbConnect.executeUpdate(Auditing.query2(UserText.getText(), TableText.getText()));
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }

        UserText.clear();
        TableText.clear();
    }
    public void DisableAuditUser(ActionEvent e)
    {
        if(CheckCondition()==0)
            return;

        try
        {
            DbConnect.executeUpdate(Auditing.query3(UserText.getText(), TableText.getText()));
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }

        UserText.clear();
        TableText.clear();
    }

    public int CheckCondition()
    {
        if(UserText.getText().isEmpty() || TableText.getText().isEmpty())
        {
            return 0;
        }
        return 1;
    }
}
