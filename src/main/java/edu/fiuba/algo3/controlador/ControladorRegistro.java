package edu.fiuba.algo3.controlador;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.registro.Puntaje;
import edu.fiuba.algo3.modelo.registro.Registro;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ControladorRegistro{
   
    private Registro registro;

    public ControladorRegistro() {
        this.registro = new Registro();
    }

    public void registrar(Button boton, TextField ingreso, ControladorJuego juego) {

        if (ingreso.getText().length() != 0) {
            this.registro.cargarPuntaje(new Puntaje(ingreso.getText(), juego.getMovimientos()));
    
            ingreso.setDisable(true);
            boton.setDisable(true);
            boton.setText("Guardado!");
        }
    }

    public ArrayList<Puntaje> getPuntajes() {
        return this.registro.obtenerPuntajes();
    }
}
