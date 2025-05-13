package com.example.vue;

import com.example.controleur.Controleur;
import com.example.modele.Reservation;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;



public class TableViewPlanning extends VBox {
    private Label lbNumSemaine;

    public TableViewPlanning(Controleur controleur) {
        super();
        lbNumSemaine = new Label("Semaine ");
        this.getChildren().add(lbNumSemaine);
        TableView t = new TableView();
        this.getChildren().add(t);


    }



    public void updateNumSemaine(String n) {
        lbNumSemaine.setText(n);
    }


}
