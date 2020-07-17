package utils;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class Utils {
    public static String hashData (String data) {
        String hashed = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(data.getBytes());
            byte[] digest = md.digest();
//            hashed = DatatypeConverter.printHexBinary(digest).toUpperCase();
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hashed;
    }
    public static void setCellValueFactory(TableView tbv, int index, String property) {
        TableColumn column = (TableColumn)tbv.getColumns().get(index);
        column.setCellValueFactory(new PropertyValueFactory<>(property));
    }
}
