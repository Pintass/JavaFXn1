package com.example.controleur;

import com.example.modele.DateCalendrier;
import com.example.modele.PlanningCollections;
import com.example.vue.Formulaire;
import com.example.vue.HBoxRoot;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;

public class Controleur implements EventHandler {
    @Override
    public void handle(Event event) {
        PlanningCollections planning = HBoxRoot.getPlanning();
        Formulaire reservationPane = HBoxRoot.getFormulairePane();

        // la source de event est un ToggleButton du calendrier
        if (event.getSource() instanceof ToggleButton) {
            ToggleButton clickedButton = (ToggleButton)event.getSource();
            DateCalendrier selDate = (DateCalendrier)clickedButton.getUserData();
            System.out.println(clickedButton.getUserData() + "ds contr");
        }

        // la source de event est le bouton "Enregistrer" du formulaire de réservation
        if (event.getSource() instanceof Button) {
            Button clickedButton = (Button)event.getSource();
            System.out.println(clickedButton);
        }
    }
}
