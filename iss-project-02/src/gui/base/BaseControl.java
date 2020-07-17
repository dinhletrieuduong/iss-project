package gui.base;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public abstract class BaseControl extends AnchorPane implements Initializable {
    public BaseControl(String filename) {
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
