package edu.fiuba.algo3.vista.vehiculo;

import java.util.ResourceBundle.Control;

import edu.fiuba.algo3.controlador.ControladorJuego;
import edu.fiuba.algo3.controlador.Observer;
import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.vista.tablero.VistaTablero;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class VistaVehiculo extends Pane implements Observer {

    private final double tamanioVehiculo = 15;
    private ImageView modeloVehiculo;
    private Celda posicionAnterior;
    private VistaTablero tablero;
    private ControladorJuego juego;

    public VistaVehiculo(VistaTablero tablero, ControladorJuego juego) {
        this.tablero = tablero;
        this.juego = juego;
        this.posicionAnterior = this.juego.obtenerPosicion();
        
        this.modeloVehiculo = new ImageView();
        this.modeloVehiculo.setFitHeight(tamanioVehiculo);
        this.modeloVehiculo.setFitWidth(tamanioVehiculo);
        this.modeloVehiculo.maxHeight(tamanioVehiculo);
        this.modeloVehiculo.maxWidth(tamanioVehiculo);
        this.modeloVehiculo.setPreserveRatio(true);

        BorderPane pane = new BorderPane();
        
        pane.setMinSize(20, 20);
        pane.setCenter(this.modeloVehiculo);
        
        this.setNuevoAuto(this.juego.getVehiculo().getNombre());
        tablero.agregarVistaAPosicion(pane, this.posicionAnterior);
    }

    @Override
    public void update() {
        Celda nuevaPosicion = this.juego.getVehiculo().getPosicion();

        this.setNuevoAuto(this.juego.getVehiculo().getNombre());
        this.rotar(this.posicionAnterior, nuevaPosicion);
        this.posicionAnterior = nuevaPosicion;
        this.tablero.agregarVistaAPosicion(this.modeloVehiculo, nuevaPosicion);
    }

    public void setNuevoAuto(String nombre) {
        this.modeloVehiculo.setImage(new Image(nombre + ".png"));
    }

    public void rotar(Celda anterior, Celda siguiente) {
        // X e Y pueden ser -1, 0 o 1
        double y = anterior.fila() - siguiente.fila();
        double x = anterior.columna() - siguiente.columna();

        // Un poco feo pero soluciona el problema
        if (y != 0) {
            this.modeloVehiculo.setRotate((- y * 90));
        }

        if (x > 0) {
            this.modeloVehiculo.setRotate(180);
        }

        if (x < 0) {
            this.modeloVehiculo.setRotate(0);
        }
    }
    
    
}
