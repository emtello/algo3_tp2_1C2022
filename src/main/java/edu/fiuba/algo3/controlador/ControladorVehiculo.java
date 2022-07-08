package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.direccion.Abajo;
import edu.fiuba.algo3.modelo.direccion.Arriba;
import edu.fiuba.algo3.modelo.direccion.Derecha;
import edu.fiuba.algo3.modelo.direccion.Izquierda;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ControladorVehiculo implements EventHandler<KeyEvent> {
    private ControladorJuego juego;
    private App app;

    public ControladorVehiculo(ControladorJuego juego, App app) {
        this.app = app;
        this.juego = juego;
    }

    @Override
    public void handle(KeyEvent key) {
        Boolean llego = false;

        try {
            if (key.getCode() == KeyCode.UP) {
                llego = this.juego.mover(new Arriba());
            }
            else if(key.getCode() == KeyCode.DOWN) {
                llego = this.juego.mover(new Abajo());
            }
            else if (key.getCode() == KeyCode.RIGHT) {
                llego = this.juego.mover(new Derecha());
            }
            else if (key.getCode() == KeyCode.LEFT) {
                llego = this.juego.mover(new Izquierda());
            }
            
            if (llego) this.app.mostrarVentanaJuegoCompleto();
            
            this.juego.notificar();
            
        } catch (Exception ignorado) {
            return;
        }
        return;
    }
}
