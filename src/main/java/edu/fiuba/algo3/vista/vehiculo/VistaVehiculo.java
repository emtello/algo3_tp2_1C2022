package edu.fiuba.algo3.vista.vehiculo;

import java.util.Observable;
import java.util.Observer;

import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;
import edu.fiuba.algo3.vista.tablero.VistaTablero;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class VistaVehiculo extends Pane implements Observer {

    private ImageView modeloVehiculo;
    private Celda celda;
    private VistaTablero tablero;

    public VistaVehiculo(VistaTablero tablero, Vehiculo vehiculo) {
        this.tablero = tablero;

        Image image = new Image("auto-derecha.jpg");

        this.modeloVehiculo = new ImageView(image);
        this.modeloVehiculo.setFitHeight(20);
        this.modeloVehiculo.setFitWidth(20);
        
        this.celda = vehiculo.getPosicion();
        tablero.agregarVistaAPosicion(this.modeloVehiculo, celda);
    }

    @Override
    public void update(Observable o, Object arg) {
        Celda nuevaPosicion = (Celda) arg;
        this.tablero.agregarVistaAPosicion(this.modeloVehiculo, nuevaPosicion);
    }

    
}
