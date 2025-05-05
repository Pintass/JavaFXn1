package com.example.vue;
import com.example.modele.DateCalendrier;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class Formulaire extends GridPane {
    public Formulaire() {
        super();
        DateCalendrier today = new DateCalendrier();
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);

        Label dateJour = new Label(today.toString());

        GridPane.setColumnSpan(dateJour, 6);
        GridPane.setHalignment(dateJour, HPos.CENTER);
        grid.add(dateJour, 0, 0);




        // Text field de la réservation

        Label labelCours = new Label("_Cours");
        labelCours.setMnemonicParsing(true);
        TextField textFieldCours = new TextField();

        Platform.runLater(textFieldCours::requestFocus); // afin de focus sur le text field
        labelCours.setLabelFor(textFieldCours); // associer le textfield au label

        grid.add(labelCours, 0, 1);
        grid.add(textFieldCours, 1, 1);
        GridPane.setColumnSpan(textFieldCours, 5);




        // Radio boutons

        Label niveauLabel = new Label("Niveau");
        grid.add(niveauLabel, 0, 2);

        ToggleGroup tgroup = new ToggleGroup();

        RadioButton debutantButton = new RadioButton("_débutant");
        debutantButton.setSelected(true);
        debutantButton.setMnemonicParsing(true);
        debutantButton.setAccessibleText("débutant");
        grid.add(debutantButton, 2, 2);


        RadioButton moyenButton = new RadioButton("_moyen");
        moyenButton.setMnemonicParsing(true);
        moyenButton.setAccessibleText("_moyen");
        grid.add(moyenButton, 4, 2);

        RadioButton avanceButton = new RadioButton("_avancé");
        avanceButton.setMnemonicParsing(true);
        avanceButton.setAccessibleText("avance");
        grid.add(avanceButton, 2, 3);

        RadioButton expertButton = new RadioButton("_expert");
        expertButton.setMnemonicParsing(true);
        expertButton.setAccessibleText("expert");
        grid.add(expertButton, 4, 3);

        debutantButton.setToggleGroup(tgroup);
        moyenButton.setToggleGroup(tgroup);
        avanceButton.setToggleGroup(tgroup);
        expertButton.setToggleGroup(tgroup);

        // Partie Horaires

        Label horaireLabel = new Label("Horaire");
        grid.add(horaireLabel, 0, 4);

        Label deLabel = new Label("de");
        grid.add(deLabel, 1, 4);

        ComboBox<Integer> heure1Combo = new ComboBox<>();
        for(int i = 0; i < 24; i++) {
            heure1Combo.getItems().addAll(i);
        }
        heure1Combo.setValue(7);
        grid.add(heure1Combo, 2, 4);


        Label hLabel = new Label("h");
        grid.add(hLabel, 3, 4);

        ComboBox<Integer> min1Combo = new ComboBox<>();
        for(int i = 0; i < 60; i+=15) {
            min1Combo.getItems().addAll(i);
        }
        min1Combo.setValue(0);
        grid.add(min1Combo, 4, 4);

        Label minLabel = new Label("min");
        grid.add(minLabel, 5, 4);

        // 2e ligne d'horaires


        Label aLabel = new Label("à");
        grid.add(aLabel, 2, 5);

        ComboBox<Integer> heure2Combo = new ComboBox<>();
        for(int i = 0; i < 24; i++) {
            heure2Combo.getItems().addAll(i);
        }
        heure2Combo.setValue(19);
        grid.add(heure2Combo, 2, 5);

        Label h2Label = new Label("h");
        grid.add(h2Label, 3, 5);

        ComboBox<Integer> min2Combo = new ComboBox<>();
        for(int i = 0; i < 60; i+=15) {
            min2Combo.getItems().addAll(i);
        }
        min2Combo.setValue(0);
        grid.add(min2Combo, 4, 5);

        Label min2Label = new Label("min");
        grid.add(min2Label, 5, 5);

        Button annulerButton = new Button("A_nnuler");
        grid.add(annulerButton, 0, 6);
        annulerButton.setMnemonicParsing(true);
        GridPane.setColumnSpan(annulerButton, 4);
        GridPane.setHalignment(annulerButton, HPos.RIGHT);



        Button enregistrerButton = new Button("En_registrer");
        grid.add(enregistrerButton, 5, 6);
        enregistrerButton.setMnemonicParsing(true);
        GridPane.setHalignment(enregistrerButton, HPos.RIGHT);



        // Ajout final
        this.getChildren().addAll(grid);


    }
}
