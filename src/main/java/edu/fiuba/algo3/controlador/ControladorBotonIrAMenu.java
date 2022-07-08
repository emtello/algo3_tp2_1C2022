package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class ControladorBotonIrAMenu implements EventHandler<ActionEvent> {

    private Stage stage;
    private Scene scene;

    public ControladorBotonIrAMenu(Stage stage, Scene escenaMenu) {
        this.stage = stage;
        this.scene = escenaMenu;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.stage.setScene(this.scene);
    }
}
