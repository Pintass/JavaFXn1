package com.example.vue;

import com.example.controleur.Controleur;
import com.example.modele.ExceptionPlanning;
import com.example.modele.PlanningCollections;
import javafx.scene.layout.HBox;

import javax.swing.text.TableView;

public class HBoxRoot extends HBox {
    private static PlanningCollections planning;
    private static Controleur controleur;
    private static GridPane calendrierPane;
    private static Formulaire formulairePane;
    private static TableViewPlanning tableViewPlanning;

    public HBoxRoot() throws ExceptionPlanning {
        super(20);
        planning = new PlanningCollections();
        controleur = new Controleur();
        calendrierPane = new GridPane(controleur);
        formulairePane = new Formulaire(controleur);
        tableViewPlanning = new TableViewPlanning(controleur);
        this.getChildren().add(calendrierPane);
        this.getChildren().add(formulairePane);
        this.getChildren().add(tableViewPlanning);

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

    public static TableViewPlanning getTableViewPlanning() {
        return tableViewPlanning;
    }
}
