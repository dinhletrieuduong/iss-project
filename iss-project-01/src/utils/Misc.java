package utils;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.Optional;

public class Misc {
    public static void setCellValueFactory(TableView tbv, int index, String property) {
        TableColumn column = (TableColumn)tbv.getColumns().get(index);
        column.setCellValueFactory(new PropertyValueFactory<>(property));
    }

    public static ArrayList<String> findCommon(ArrayList<String> l1, ArrayList<String> l2) {
        var res = new ArrayList<String>();
        for (var i : l1) {
            if (l2.contains(i)) {
                res.add(i);
            }
        }
        return res;
    }

    public static ArrayList<String> diff(ArrayList<String> l1, ArrayList<String> l2) {
        l1.removeAll(l2);
        return l1;
    }

    public static void showMsg(String title, String header, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    public static boolean showConfirmation(String title, String header, String msg) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(msg);

        Optional<ButtonType> result = alert.showAndWait();
        return result.get() == ButtonType.OK;
    }
}
