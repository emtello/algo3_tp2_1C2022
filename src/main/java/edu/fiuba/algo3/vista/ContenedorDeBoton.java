package edu.fiuba.algo3.vista;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ContenedorDeBoton extends HBox {
    public ContenedorDeBoton(Stage escenario, Scene escenaSalirDeJuego) {
        super();
        this.setHeight(20);
        this.getChildren().add(new BotonIrAMenu(escenario, escenaSalirDeJuego));
        this.setAlignment(Pos.BOTTOM_CENTER);


    }
}
