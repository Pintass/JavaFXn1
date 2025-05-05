package com.example.vue;

import com.example.modele.CalendrierDuMois;
import com.example.modele.ConstantesCalendrier;
import com.example.modele.DateCalendrier;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

import java.util.List;

public class GridPane extends VBox implements ConstantesCalendrier {
    public GridPane() {
        super();
        DateCalendrier today = new DateCalendrier();
        StackPane stackPaneMois = new StackPane();
        ToggleGroup buttonGroup = new ToggleGroup();

        Button suivant = new Button(">");
        Button precedent = new Button("<");
        Button fin = new Button(">>");
        Button debut = new Button("<<");


        for (int i = 1; i < 13; i++) {
            CalendrierDuMois mois = new CalendrierDuMois(i, today.getAnnee());

            TilePane tilePane = new TilePane();
            tilePane.setPrefColumns(7);
            tilePane.setPrefRows(mois.getDates().size());

            tilePane.setId("opaque");

            for(String jourAb : JOURS_SEMAINE_ABR) {
                Label labelJour = new Label(jourAb);
                tilePane.getChildren().add(labelJour);
            }

            for (DateCalendrier date : mois.getDates()) {

                ToggleButton boutonDate = new ToggleButton(Integer.toString(date.getJour()));

                boutonDate.setToggleGroup(buttonGroup);
                tilePane.getChildren().add(boutonDate);

                boutonDate.setUserData(date);
                boutonDate.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        boutonDate.setId("toggle-button");
                    }
                });
                if(date.getMois() != mois.getMois()) {
                    boutonDate.setId("dateHorsMois");
                }
                if(date.isToday()){
                    boutonDate.setId("ajd");
                }

            }


            tilePane.setAccessibleText(MOIS[i-1]);
            stackPaneMois.getChildren().add(tilePane);
        }

        this.getChildren().add(stackPaneMois);

        HBox h1 = new HBox();
        h1.getChildren().add(precedent);
        h1.getChildren().add(suivant);

        HBox h2 = new HBox();
        h2.getChildren().add(debut);
        h2.getChildren().add(fin);

        this.getChildren().add(h1);
        this.getChildren().add(h2);

        List<Node> listeNode = stackPaneMois.getChildren();
        final int dernierIndice = listeNode.size() - 1;
        Node janvier = listeNode.getFirst();
        Node decembre = listeNode.get(dernierIndice);

        while (!listeNode.get(dernierIndice).getAccessibleText().equals(MOIS[today.getMois() - 1])) {
            listeNode.get(dernierIndice).toBack();
        }

        suivant.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                listeNode.getFirst().toFront();
            }
        });

        precedent.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                listeNode.getLast().toBack();
            }
        });

        fin.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                while (listeNode.getLast() != decembre) {
                    listeNode.getLast().toBack();
                }
            }
        });

        debut.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                while (listeNode.getLast() != janvier){
                    listeNode.getFirst().toFront();
                }
            }
        });


    }

}