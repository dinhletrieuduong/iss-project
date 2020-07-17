package gui.entities;

import entities.Column;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class ManageTableRow {
    private TextField columnName = new TextField();
    private ComboBox attrType = new ComboBox();
    private CheckBox nullable = new CheckBox();

    public ManageTableRow() {
        setup();
    }

    public ManageTableRow(Column col) {
        setup();
        columnName.setText(col.getColumnName());
        var attr = col.getAttrType();

        if (attr.equals("NVARCHAR2") ||
            attr.equals("VARCHAR2") ||
            attr.equals("CHAR") ||
            attr.equals("NCHAR") ||
            attr.equals("NUMBER")) {
            attr += "(" + col.getDataLength() + ")";
        }

        attrType.getSelectionModel().select(attr);
        nullable.setSelected(col.isNullable());
    }

    private void setup() {
        attrType.getItems().add("INTEGER");
        attrType.getItems().add("FLOAT");
        attrType.getItems().add("DATE");
        attrType.getItems().add("NVARCHAR2(100)");
        attrType.setEditable(true);
        attrType.getSelectionModel().select(0);
        nullable.setSelected(true);
    }

    public TextField getColumnName() {
        return columnName;
    }

    public ComboBox getAttrType() {
        return attrType;
    }

    public CheckBox getNullable() {
        return nullable;
    }
}
