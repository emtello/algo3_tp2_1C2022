package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.IngresoDeNombre;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControladorBotonIrAJuego implements EventHandler<ActionEvent> {

    private Stage stage;
    private Scene scene;

    private IngresoDeNombre ingresoDeNombre;

    public ControladorBotonIrAJuego(IngresoDeNombre ingresoDeNombre, Stage stage, Scene escenaJuego) {
        this.ingresoDeNombre = ingresoDeNombre;
        this.stage = stage;
        this.scene = escenaJuego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        // String nombre = ingresoDeNombre.getText();
        // this.tablero.registrarPuntaje(nombre);
       // System.out.println(nombre);
    //    System.out.println(this.tablero.obtenerNombre());
        this.stage.setScene(this.scene);

    }
}
