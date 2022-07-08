package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.direccion.Abajo;
import edu.fiuba.algo3.modelo.direccion.Arriba;
import edu.fiuba.algo3.modelo.direccion.Derecha;
import edu.fiuba.algo3.modelo.direccion.Izquierda;
import edu.fiuba.algo3.modelo.tablero.Tablero;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ControladorVehiculo implements EventHandler<KeyEvent> {
    private Tablero tablero;
    private App app;

    public ControladorVehiculo(Tablero tablero, App app) {
        this.app = app;
        this.tablero = tablero;
    }

    @Override
    public void handle(KeyEvent key) {
        Boolean llego = false;

        try {
            if (key.getCode() == KeyCode.UP) {
                llego = this.tablero.mover(new Arriba());
            }
            else if(key.getCode() == KeyCode.DOWN) {
                llego = this.tablero.mover(new Abajo());
            }
            else if (key.getCode() == KeyCode.RIGHT) {
                llego = this.tablero.mover(new Derecha());
            }
            else if (key.getCode() == KeyCode.LEFT) {
                llego = this.tablero.mover(new Izquierda());
            }
            
            this.tablero.notificarObservadores();
            this.tablero.notifyObservers();
            System.out.println(this.tablero.obtenerPosicion().toString());
            
            if (llego) this.app.mostrarVentanaJuegoCompleto();
            
        } catch (Exception ignorado) {
            return;
        }
        return;
    }
}
