package vue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import modele.CalendrierDuMois;
import modele.ConstantesCalendrier;
import modele.DateCalendrier;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class VBoxRootStack extends VBox implements ConstantesCalendrier {
    public VBoxRootStack() {
        super(15);

        DateCalendrier today = new DateCalendrier();
        StackPane stackPaneMois = new StackPane();

        Button suivant = new Button(">");
        Button precedent = new Button("<");
        Button fin = new Button(">>");
        Button debut = new Button("<<");


        for (int i = 1; i < 13; i++) {
            VBox v = new VBox();
            CalendrierDuMois mois = new CalendrierDuMois(i, today.getAnnee());
            ScrollPane moisPane = new ScrollPane();
            Label moisLabel = new Label();
            moisPane.setContent(v);
            stackPaneMois.getChildren().add(moisPane);
            moisPane.setAccessibleText(MOIS[i - 1]);

            Collection<DateCalendrier> test = mois.getDates();
            Iterator<DateCalendrier> iterateur = test.iterator();
            while (iterateur.hasNext()) {
                DateCalendrier date = iterateur.next();
                if (date.compareTo(today) == 0) {
                    Label textajd = new Label(today.toString());
                    v.getChildren().add(textajd);
                    textajd.setId("ajd");

                } else {
                    Label textdate = new Label(date.toString());
                    v.getChildren().add(textdate);
                }
            }
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