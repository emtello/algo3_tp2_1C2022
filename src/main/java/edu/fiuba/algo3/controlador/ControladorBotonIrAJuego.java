package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControladorBotonIrAJuego implements EventHandler<ActionEvent> {

    private Stage stage;
    private Scene scene;
    public ControladorBotonIrAJuego(Stage stage, Scene escenaJuego) {
        this.stage = stage;
        this.scene = escenaJuego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.stage.setScene(this.scene);
    }
}
