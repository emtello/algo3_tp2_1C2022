package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControladorBotonSi implements EventHandler<ActionEvent> {

    private Stage stage;
    private Scene scene;

    public ControladorBotonSi(Stage stage, Scene scene) {
        this.stage = stage;
        this.scene = scene;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.stage.setScene(this.scene);
    }
}
