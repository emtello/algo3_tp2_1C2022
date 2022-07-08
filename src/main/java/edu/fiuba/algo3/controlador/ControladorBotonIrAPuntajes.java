package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControladorBotonIrAPuntajes implements EventHandler<ActionEvent> {

    private Stage stage;
    private Scene scene;
    public ControladorBotonIrAPuntajes(Stage stage, Scene escenaMejoresPuntajes) {
        this.stage = stage;
        this.scene = escenaMejoresPuntajes;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.stage.setScene(this.scene);
    }
}
