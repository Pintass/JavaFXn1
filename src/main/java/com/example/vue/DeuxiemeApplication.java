package com.example.vue;

import com.example.controleur.Controleur;
import com.example.modele.ExceptionPlanning;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;

public class DeuxiemeApplication extends Application {
    @Override
    public void start(Stage stage) throws ExceptionPlanning {

        File css = new File("css" + File.separator+"styles.css");

        HBoxRoot root = new HBoxRoot();
        Scene scene = new Scene(root, 1600, 700);
        stage.setScene(scene);
        stage.setTitle("Daniel Rodrigues Amorim - INF1-B | JavaPlanning");
        scene.getStylesheets().add(css.toURI().toString());
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}

