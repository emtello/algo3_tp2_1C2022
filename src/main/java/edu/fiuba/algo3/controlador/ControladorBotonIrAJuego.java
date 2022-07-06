package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.tablero.Tablero;
import edu.fiuba.algo3.vista.BotonIrAJuego;
import edu.fiuba.algo3.vista.IngresoDeNombre;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControladorBotonIrAJuego implements EventHandler<ActionEvent> {

    private Stage stage;
    private Scene scene;

    private Tablero tablero;

    private IngresoDeNombre ingresoDeNombre;

    public ControladorBotonIrAJuego(IngresoDeNombre ingresoDeNombre, Tablero tablero, Stage stage, Scene escenaJuego) {
        this.ingresoDeNombre = ingresoDeNombre;
        this.tablero = tablero;
        this.stage = stage;
        this.scene = escenaJuego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String nombre = ingresoDeNombre.getText();
        this.tablero.registrarPuntaje(nombre);
       // System.out.println(nombre);
       // System.out.println(this.tablero.obtenerNombre());
        this.stage.setScene(this.scene);

    }
}
