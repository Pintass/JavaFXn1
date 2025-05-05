package com.example.vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;

public class DeuxiemeApplication extends Application {
    @Override
    public void start(Stage stage) {

        File css = new File("css" + File.separator+"styles.css");
        HBoxRoot root = new HBoxRoot();

        Scene scene = new Scene(root, 800, 400);
        stage.setScene(scene);
        stage.setTitle("Daniel Rodrigues Amorim");
        scene.getStylesheets().add(css.toURI().toString());
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}

