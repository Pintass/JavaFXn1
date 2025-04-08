package vue;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import modele.DateCalendrier;
import modele.CalendrierDuMois;

import java.util.Collection;
import java.util.Iterator;

public class VBoxDates extends VBox {
    public VBoxDates(int nbDuMois, int annee) {
        super(15);
        VBox v = new VBox();
        ScrollPane scrollPaneDates = new ScrollPane();
        scrollPaneDates.setContent(v);
        VBox.setMargin(scrollPaneDates, new Insets(15));
        DateCalendrier ajd = new DateCalendrier();

        CalendrierDuMois cal = new CalendrierDuMois(nbDuMois, annee);
        Collection<DateCalendrier> test = cal.getDates();
        Iterator<DateCalendrier> iterateur = test.iterator();
        while(iterateur.hasNext()){
            DateCalendrier date = iterateur.next();
            if (date.compareTo(ajd) == 0) {
                Label textajd = new Label(ajd.toString());
                v.getChildren().add(textajd);
                textajd.setId("ajd");
            } else {
                Label textdate = new Label(date.toString());
                v.getChildren().add(textdate);
            }
        }
        this.getChildren().add(scrollPaneDates);




    }
}
