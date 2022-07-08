package edu.fiuba.algo3.vista.vehiculo;

import java.util.Observable;
import java.util.Observer;

import edu.fiuba.algo3.controlador.ControladorVehiculo;
import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.tablero.Tablero;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;
import edu.fiuba.algo3.vista.tablero.VistaTablero;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class VistaVehiculo extends Pane implements Observer {

    private final double tamanioVehiculo = 15;
    private ImageView modeloVehiculo;
    private Celda celda;
    private VistaTablero vistaTablero;
    ControladorVehiculo controladorVehiculo;

    public VistaVehiculo(VistaTablero vistaTablero, String vehiculo, Celda celda) {
        this.vistaTablero = vistaTablero;
        this.celda = celda;
        
        this.modeloVehiculo = this.obtenerImagen(vehiculo);

        BorderPane pane = new BorderPane();
        
        pane.setMinSize(20, 20);
        pane.setCenter(this.modeloVehiculo);

        vistaTablero.agregarVistaAPosicion(pane, celda);
    }

    @Override
    public void update(Observable o, Object arg) {
        Celda nuevaPosicion = (Celda) arg;
        Vehiculo v = (Vehiculo) o;

        this.setNuevoAuto(v.getNombre());
        this.rotar(this.celda, nuevaPosicion);
        this.celda = nuevaPosicion;

        this.vistaTablero.agregarVistaAPosicion(this.modeloVehiculo, nuevaPosicion);
    }

    public ImageView obtenerImagen(String vehiculo) {
        Image image = new Image(vehiculo + ".png");

        ImageView modeloVehiculo = new ImageView(image);

        modeloVehiculo.setFitHeight(15);
        modeloVehiculo.setFitWidth(15);

        modeloVehiculo.maxHeight(15);
        modeloVehiculo.maxWidth(15);
        
        modeloVehiculo.setPreserveRatio(true);
        
        return modeloVehiculo;
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
