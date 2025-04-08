package vue;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import modele.CalendrierDuMois;
import modele.DateCalendrier;

import java.util.Collection;
import java.util.Iterator;

public class VBoxRootStack {
    public VBoxRootStack() {
        super(15);
        VBox v = new VBox();
        StackPane stackPaneMois = new StackPane();
         for (int i = 1; 12; i++) {
             CalendrierDuMois mois = new CalendrierDuMois(i,2025);
             ScrollPane moisPane = new ScrollPane();
             Label moisLabel = new Label();
         }

    }
}
