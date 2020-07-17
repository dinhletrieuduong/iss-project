package gui.base;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class BaseDialog extends AnchorPane implements Initializable {
    private Stage stage;
    private String filename;
    private int width;
    private int height;
    private String title = "";
    private boolean resizable = true;

    public BaseDialog(String filename, int width, int height) {
        this.filename = filename;
        this.width = width;
        this.height = height;
        try {
            stage = new Stage();
            stage.setResizable(resizable);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(loadScene());
            stage.setTitle(title);
            addEscCloseEvent();
//            setup();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void loadBeforeShow() {
    }

    public void close() {
        stage.close();
    }

    public void showAndWait() {
        loadBeforeShow();
        stage.showAndWait();
    }

    private Scene loadScene() throws IOException {
//        System.out.println("Load scene");
        FXMLLoader loader = new FXMLLoader(getClass().getResource(filename));
        loader.setController(this);
        loader.setRoot(this);
        Parent parent = loader.load();
        return new Scene(parent, width, height);
    }

    private void addEscCloseEvent() {
        stage.addEventHandler(KeyEvent.KEY_PRESSED, (EventHandler<KeyEvent>) e -> {
            if (e.getCode() == KeyCode.ESCAPE) {
                stage.close();
            }
        });
    }

    public void setTitle(String tit) { this.title = tit; }

    public void setResizable(boolean resizable) {
        this.resizable = resizable;
    }
}
