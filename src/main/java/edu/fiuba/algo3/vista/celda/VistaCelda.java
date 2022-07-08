package edu.fiuba.algo3.vista.celda;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class VistaCelda extends Pane {

    private final int dimensionCelda = 20;

    public VistaCelda(Color color) {
        this.setMinSize(dimensionCelda, dimensionCelda);
        this.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
    }
    
}
