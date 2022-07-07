package edu.fiuba.algo3.vista.vehiculo;

import java.util.Observable;
import java.util.Observer;

import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.tablero.Tablero;
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
    private Tablero modeloTablero;

    public VistaVehiculo(VistaTablero tablero, Tablero modeloTablero) {
        this.tablero = tablero;
        this.modeloTablero = modeloTablero;
        this.posicionAnterior = this.modeloTablero.obtenerPosicion();
        
        this.modeloVehiculo = new ImageView();
        this.modeloVehiculo.setFitHeight(tamanioVehiculo);
        this.modeloVehiculo.setFitWidth(tamanioVehiculo);
        this.modeloVehiculo.maxHeight(tamanioVehiculo);
        this.modeloVehiculo.maxWidth(tamanioVehiculo);
        this.modeloVehiculo.setPreserveRatio(true);

        BorderPane pane = new BorderPane();
        
        pane.setMinSize(20, 20);
        pane.setCenter(this.modeloVehiculo);
        
        this.setNuevoAuto(this.modeloTablero.obtenerTipoVehiculo());
        tablero.agregarVistaAPosicion(pane, this.posicionAnterior);
    }

    @Override
    public void update(Observable o, Object arg) {
        Celda nuevaPosicion = (Celda) arg;

        this.setNuevoAuto(this.modeloTablero.obtenerTipoVehiculo());
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
