package vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;

public class DeuxiemeApplication extends Application {
    @Override
    public void start(Stage stage) {

        File css = new File("css" + File.separator+"styles.css");
        VBoxRootStack root = new VBoxRootStack();

        Scene scene = new Scene(root, 800, 800);
        stage.setScene(scene);
        stage.setTitle("Calendrier sous ScrollPane");
        scene.getStylesheets().add(css.toURI().toString());
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}

