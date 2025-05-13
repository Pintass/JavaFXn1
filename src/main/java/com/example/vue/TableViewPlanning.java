package com.example.vue;

import com.example.controleur.Controleur;
import com.example.modele.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


public class TableViewPlanning extends VBox {
    private Integer n;
    private Label lbNumSemaine;
    private PlanningCollections planning = HBoxRoot.getPlanning();
    private Formulaire reservationPane = HBoxRoot.getFormulairePane();
    private TableView<Reservation> t;

    public TableViewPlanning(Controleur controleur) throws ExceptionPlanning {
        super();

        lbNumSemaine = new Label("Semaine ");
        this.getChildren().add(lbNumSemaine);

        t = new TableView();
        this.getChildren().add(t);


        //mise en place des colonnes de la table view
        TableColumn<Reservation, DateCalendrier> dateColumn = new TableColumn<>("Date");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        t.getColumns().add(dateColumn);

        TableColumn<Reservation, DateCalendrier> titleColumn = new TableColumn<>("Intitule");
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("intitule"));
        t.getColumns().add(titleColumn);

        TableColumn<Reservation, DateCalendrier> hourColumn = new TableColumn<>("Horaire");
        hourColumn.setCellValueFactory(new PropertyValueFactory<>("horaire"));
        t.getColumns().add(hourColumn);

        t.setPrefSize(400,400);
        t.setMaxSize(400,400);
        dateColumn.setMinWidth(75);
        titleColumn.setMinWidth(150);
        hourColumn.setMinWidth(170);

        //interdiction de réordonner la colonne des titres
        titleColumn.setReorderable(false);
        dateColumn.setReorderable(false);
        hourColumn.setReorderable(false);

    }

    public void updatePlanning(Integer n) {
        t.getItems().clear();
        if(planning.getReservations().containsKey(n)) {
            for (Reservation reservation : planning.getReservations().get(n)) {
                t.getItems().add(reservation);
            }
        }
    }

    public void updateNumSemaine(String n) {
        lbNumSemaine.setText(n);
    }


}
