package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorIngresoDeNombre;
import edu.fiuba.algo3.modelo.tablero.Tablero;
import javafx.scene.control.TextField;

public class IngresoDeNombre extends TextField {

    public IngresoDeNombre() {
        super();
        this.setPromptText("Ingresar Nombre y luego haga click en Jugar");
        this.setFocusTraversable(false);
       // this.setOnAction(new ControladorIngresoDeNombre());
    }
}
