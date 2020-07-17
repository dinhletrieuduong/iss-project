package gui;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public abstract class ControlBase extends AnchorPane implements Initializable {
    public ControlBase(String filename) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(filename));
            loader.setRoot(this);
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
