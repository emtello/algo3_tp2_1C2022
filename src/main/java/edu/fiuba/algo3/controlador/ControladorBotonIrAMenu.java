package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class ControladorBotonIrAMenu implements EventHandler<ActionEvent> {

    private Stage escenario;
    private Scene escena;

    public ControladorBotonIrAMenu(Stage stage, Scene escenaMenu) {
        this.escenario = stage;
        this.escena = escenaMenu;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.escenario.setScene(this.escena);
    }
}
