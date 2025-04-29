package com.example.vue;

import javafx.scene.layout.HBox;

public class HBoxRoot extends HBox {
    public HBoxRoot() {
        super(20);
        TilePaneTD3 tilePane = new TilePaneTD3();
        this.getChildren().add(tilePane);

        Formulaire form = new Formulaire();
        this.getChildren().add(form);

    }

}
