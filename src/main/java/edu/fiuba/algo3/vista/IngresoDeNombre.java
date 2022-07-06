package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorIngresoDeNombre;
import edu.fiuba.algo3.modelo.tablero.Tablero;
import javafx.scene.control.TextField;

public class IngresoDeNombre extends TextField {

    public IngresoDeNombre(Tablero tablero) {
        super();
        this.setPromptText("Ingresar Nombre");
        this.setFocusTraversable(false);
        this.setOnAction(new ControladorIngresoDeNombre(this, tablero));
    }
}
