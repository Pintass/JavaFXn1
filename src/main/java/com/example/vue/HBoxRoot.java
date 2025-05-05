package com.example.vue;

import com.example.controleur.Controleur;
import com.example.modele.Planning;
import javafx.scene.layout.HBox;

public class HBoxRoot extends HBox {
    private static Planning planning;
    private static Controleur controleur;
    private static TilePaneTD3 calendrierPane;
    private static Formulaire formulairePane;

    public HBoxRoot() {
        super(20);
        planning = new Planning();
        controleur = new Controleur();
        calendrierPane = new TilePaneTD3();
        formulairePane = new Formulaire();
        this.getChildren().add(calendrierPane);
        this.getChildren().add(formulairePane);

    }

    public static Planning getPlanning() {
        return planning;
    }

    public static Controleur getControleur() {
        return controleur;
    }

    public static TilePaneTD3 getCalendrierPane() {
        return calendrierPane;
    }

    public static Formulaire getFormulairePane() {
        return formulairePane;
    }

}
