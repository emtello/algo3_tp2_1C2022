package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.tablero.Tablero;
import edu.fiuba.algo3.vista.IngresoDeNombre;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorIngresoDeNombre implements EventHandler<ActionEvent> {

    private IngresoDeNombre ingresoDeNombre;
    private Tablero tablero;

    public ControladorIngresoDeNombre(IngresoDeNombre ingresoDeNombre, Tablero tablero){
        this.ingresoDeNombre = ingresoDeNombre;
        this.tablero = tablero;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String nombre = ingresoDeNombre.getText();
        this.tablero.registrarPuntaje(nombre);
        System.out.println(nombre);
        System.out.println(this.tablero.obtenerNombre());
    }
}
