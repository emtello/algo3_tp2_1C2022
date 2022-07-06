package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.tablero.Tablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControladorBotonSiSalirDeJuego implements EventHandler<ActionEvent> {

    private Stage stage;
    private Scene scene;
    private Tablero tablero;
    public ControladorBotonSiSalirDeJuego(Tablero tablero, Stage stage, Scene scene) {
        this.tablero = tablero;
        this.stage = stage;
        this.scene = scene;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.stage.setScene(this.scene);
        //ademas terminar el juego
        this.tablero.reiniciar();
    }
}
