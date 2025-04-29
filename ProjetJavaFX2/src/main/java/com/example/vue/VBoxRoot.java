package com.example.vue;

import javafx.scene.layout.VBox;
import com.example.modele.DateCalendrier;
import javafx.scene.control.Label;

public class VBoxRoot extends VBox {
    public VBoxRoot(){
        super(15);
        DateCalendrier ajd = new DateCalendrier();
        DateCalendrier demain = ajd.dateDuLendemain();
        Label labelDate = new Label(ajd.toString());
        this.getChildren().addAll(labelDate);
        Label labelDateDemain = new Label(demain.toString());
        this.getChildren().addAll(labelDateDemain);
    }

    private class dateDuLendemain extends DateCalendrier {
    }
}
