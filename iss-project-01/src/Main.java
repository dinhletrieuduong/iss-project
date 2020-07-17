import gui.MainWindow;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.Config;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        MainWindow root = new MainWindow();
        primaryStage.setTitle("Oracle Management Studio v0.9");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    public static void main(String []args) {
        Config.open();
        launch(args);
    }
}
