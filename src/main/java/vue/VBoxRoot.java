package vue;

import javafx.scene.layout.VBox;
import modele.DateCalendrier;
import javafx.scene.control.Label;

public class VBoxRoot extends VBox {
    public VBoxRoot(){
        super(15);
        DateCalendrier ajd = new DateCalendrier();
        DateCalendrier demain = ajd.dateDuLendemain();
        Label labelDate = new Label(ajd.toString());
        this.getChildren().add(labelDate);
        Label labelDateDemain = new Label(demain.toString());
        this.getChildren().add(labelDateDemain);
    }

    private class dateDuLendemain extends DateCalendrier {
    }
}
