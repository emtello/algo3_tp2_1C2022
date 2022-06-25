package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.direccion.Abajo;
import edu.fiuba.algo3.modelo.direccion.Arriba;
import edu.fiuba.algo3.modelo.direccion.Derecha;
import edu.fiuba.algo3.modelo.direccion.Izquierda;
import edu.fiuba.algo3.modelo.tablero.Tablero;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ControladorVehiculo implements EventHandler<KeyEvent> {
    private Tablero tablero;

    public ControladorVehiculo(Tablero tablero) {
        this.tablero = tablero;
    }

    @Override
    public void handle(KeyEvent key) {
        try {
            if (key.getCode() == KeyCode.UP) {
                this.tablero.mover(new Arriba());
            }
            if (key.getCode() == KeyCode.DOWN) {
                this.tablero.mover(new Abajo());
            }
            if (key.getCode() == KeyCode.RIGHT) {
                this.tablero.mover(new Derecha());
            }
            if (key.getCode() == KeyCode.LEFT) {
                this.tablero.mover(new Izquierda());
            }
            this.tablero.notificarObservadores();
        } 
        catch (Exception ignorado)  {
            return;
        }
    }
}
