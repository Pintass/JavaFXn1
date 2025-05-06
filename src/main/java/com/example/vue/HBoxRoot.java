package com.example.vue;

import com.example.controleur.Controleur;
import com.example.modele.PlanningCollections;
import javafx.scene.layout.HBox;

public class HBoxRoot extends HBox {
    private static PlanningCollections planning;
    private static Controleur controleur;
    private static GridPane calendrierPane;
    private static Formulaire formulairePane;

    public HBoxRoot() {
        super(20);
        planning = new PlanningCollections();
        controleur = new Controleur();
        calendrierPane = new GridPane(controleur);
        formulairePane = new Formulaire(controleur);
        this.getChildren().add(calendrierPane);
        this.getChildren().add(formulairePane);

    }

    public static PlanningCollections getPlanning() {
        return planning;
    }

    public static Controleur getControleur() {
        return controleur;
    }

    public static GridPane getCalendrierPane() {
        return calendrierPane;
    }

    public static Formulaire getFormulairePane() {
        return formulairePane;
    }

}
