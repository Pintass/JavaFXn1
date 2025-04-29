package com.example.vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;

public class DeuxiemeApplication extends Application {
    @Override
    public void start(Stage stage) {

        File css = new File("css" + File.separator+"styles.css");
        TilePaneTD3 root = new TilePaneTD3();

        Scene scene = new Scene(root, 300, 400);
        stage.setScene(scene);
        stage.setTitle("Calendrier sous ScrollPane");
        scene.getStylesheets().add(css.toURI().toString());
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}

