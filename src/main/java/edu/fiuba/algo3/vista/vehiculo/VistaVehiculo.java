package edu.fiuba.algo3.vista.vehiculo;

import java.util.Observable;
import java.util.Observer;

import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;
import edu.fiuba.algo3.vista.tablero.VistaTablero;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class VistaVehiculo extends Pane implements Observer {

    private ImageView modeloVehiculo;
    private Celda celda;
    private VistaTablero tablero;

    public VistaVehiculo(VistaTablero tablero, String vehiculo, Celda celda) {
        this.tablero = tablero;
        this.celda = celda;
        
        Image image = new Image(vehiculo + ".png");

        this.modeloVehiculo = new ImageView(image);

        this.modeloVehiculo.setFitHeight(30);
        this.modeloVehiculo.setFitWidth(30);

        this.modeloVehiculo.maxHeight(20);
        this.modeloVehiculo.maxWidth(20);
        
        this.modeloVehiculo.setPreserveRatio(true);
        
        BorderPane pane = new BorderPane();

        pane.setMinSize(30, 30);
        pane.setCenter(this.modeloVehiculo);

        tablero.agregarVistaAPosicion(pane, celda);
    }

    @Override
    public void update(Observable o, Object arg) {
        Celda nuevaPosicion = (Celda) arg;

        this.rotar(this.celda, nuevaPosicion);
        this.celda = nuevaPosicion;
        this.tablero.agregarVistaAPosicion(this.modeloVehiculo, nuevaPosicion);
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
