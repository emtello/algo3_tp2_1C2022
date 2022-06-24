package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.tablero.Tablero;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;
import edu.fiuba.algo3.vista.tablero.VistaTablero;
import edu.fiuba.algo3.vista.vehiculo.VistaVehiculo;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private VistaTablero vistaTablero;
    private VistaVehiculo vistaVehiculo;

    @Override
    public void start(Stage stage) {
        Tablero tablero = new Tablero(10, 10); 
        Vehiculo vehiculo = new Moto(tablero);

        tablero.agregarvehiculo(vehiculo);
        tablero.iniciarEn(new Celda(4, 4));

        this.vistaTablero = new VistaTablero(tablero);
        
        this.vistaVehiculo = new VistaVehiculo(this.vistaTablero, vehiculo);
        tablero.addObserver(vistaVehiculo);
        
        this.vistaVehiculo = new VistaVehiculo(this.vistaTablero, vehiculo);

        VBox contenedor = new VBox(this.vistaTablero, this.vistaVehiculo);

        Scene scene = new Scene(contenedor, 640, 640);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}