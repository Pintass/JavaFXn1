package com.example.vue;
import com.example.controleur.Controleur;
import com.example.modele.DateCalendrier;
import com.example.modele.Reservation;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class Formulaire extends GridPane {
    private Label dateJour;
    private TextField textFieldCours;
    private ComboBox<Integer> heureDebut;
    private ComboBox<Integer> minHeureDebut;
    private ComboBox<Integer> heureFin;
    private ComboBox<Integer> minHeureFin;
    private Label lbMessageConfirmation;
    private DateCalendrier selDateRecord;


    public Formulaire(Controleur controleur) {
        super();
        selDateRecord = new DateCalendrier();
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);

        dateJour = new Label(selDateRecord.toString());

        GridPane.setColumnSpan(dateJour, 6);
        GridPane.setHalignment(dateJour, HPos.CENTER);
        grid.add(dateJour, 0, 0);




        // Text field de la réservation

        Label labelCours = new Label("_Cours");
        labelCours.setMnemonicParsing(true);
        textFieldCours = new TextField();

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

        heureDebut = new ComboBox<>();
        for(int i = 0; i < 24; i++) {
            heureDebut.getItems().addAll(i);
        }
        heureDebut.setValue(7);
        grid.add(heureDebut, 2, 4);


        Label hLabel = new Label("h");
        grid.add(hLabel, 3, 4);

        minHeureDebut = new ComboBox<>();
        for(int i = 0; i < 60; i+=15) {
            minHeureDebut.getItems().addAll(i);
        }
        minHeureDebut.setValue(0);
        grid.add(minHeureDebut, 4, 4);

        Label minLabel = new Label("min");
        grid.add(minLabel, 5, 4);

        // 2e ligne d'horaires


        Label aLabel = new Label("à");
        grid.add(aLabel, 2, 5);

        heureFin = new ComboBox<>();
        for(int i = 0; i < 24; i++) {
            heureFin.getItems().addAll(i);
        }
        heureFin.setValue(19);
        grid.add(heureFin, 2, 5);

        Label h2Label = new Label("h");
        grid.add(h2Label, 3, 5);

        minHeureFin = new ComboBox<>();
        for(int i = 0; i < 60; i+=15) {
            minHeureFin.getItems().addAll(i);
        }
        minHeureFin.setValue(0);
        grid.add(minHeureFin, 4, 5);

        Label min2Label = new Label("min");
        grid.add(min2Label, 5, 5);

        Button annulerButton = new Button("A_nnuler");
        annulerButton.setId("annuler");
        grid.add(annulerButton, 0, 6);
        annulerButton.setMnemonicParsing(true);
        GridPane.setColumnSpan(annulerButton, 4);
        GridPane.setHalignment(annulerButton, HPos.RIGHT);



        Button enregistrerButton = new Button("En_registrer");
        enregistrerButton.setId("enregistrer");
        enregistrerButton.addEventHandler(ActionEvent.ACTION, controleur);
        grid.add(enregistrerButton, 5, 6);
        enregistrerButton.setMnemonicParsing(true);
        GridPane.setHalignment(enregistrerButton, HPos.RIGHT);


        lbMessageConfirmation = new Label("");
        GridPane.setHalignment(lbMessageConfirmation, HPos.CENTER);
        GridPane.setColumnSpan(lbMessageConfirmation, 8);
        lbMessageConfirmation.setId("sMessageConfirmation");
        grid.add(lbMessageConfirmation, 0,10);


        // Ajout final
        this.getChildren().addAll(grid);
    }

    public void updateDateSel(DateCalendrier selDate) {
        selDateRecord = selDate;
        dateJour.setText(selDate.toString());
    }

    public DateCalendrier getDateRecord() {
        return selDateRecord;
    }

    public String getTextFieldCours() {
        return textFieldCours.getText();
    }

    public Integer getHeureDebut() {
        return heureDebut.getValue();
    }

    public Integer getHeureMinDebut() {
        return minHeureDebut.getValue();
    }

    public Integer getHeureFin() {
        return heureFin.getValue();
    }

    public Integer getMinHeureFin(){
        return minHeureFin.getValue();
    }

    public void updateMessageConfirmation(String sMessage) {
        lbMessageConfirmation.setText(sMessage);
    }
}
