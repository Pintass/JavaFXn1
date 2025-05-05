package com.example.controleur;

import com.example.modele.PlanningCollections;
import com.example.vue.Formulaire;
import com.example.vue.HBoxRoot;
import javafx.event.Event;
import javafx.event.EventHandler;

public class Controleur implements EventHandler {
    @Override
    public void handle(Event event) {
        PlanningCollections planning = HBoxRoot.getPlanning();
        Formulaire reservationPane = HBoxRoot.getReservationPane();

        // la source de event est un ToggleButton du calendrier
    }
}
