package edu.fiuba.algo3.vista.vehiculo;

import java.util.Observable;
import java.util.Observer;

import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;
import edu.fiuba.algo3.vista.tablero.VistaTablero;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class VistaVehiculo extends Pane implements Observer {

    private Pane pane;
    private Celda celda;

    public VistaVehiculo(VistaTablero tablero, Vehiculo vehiculo) {
        this.pane = new Pane();
        this.pane.setMinWidth(20);
        this.pane.setMinHeight(20);
        this.pane.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));

        this.celda = vehiculo.getPosicion();
        
        tablero.agregarVistaAPosicion(this.pane, celda);
    }

    @Override
    public void update(Observable o, Object arg) {
        
    }
    
}
