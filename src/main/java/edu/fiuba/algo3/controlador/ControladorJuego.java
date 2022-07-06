package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.tablero.Tablero;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class ControladorJuego {

    private Tablero tablero;
    private long filas;
    private long columnas;
    private Vehiculo vehiculo;
    private Celda salida;
    private Celda llegada;
    
    public ControladorJuego(long filas, long columnas) {
        this.filas = filas;
        this.columnas = columnas;

        this.tablero = new Tablero(
            (int) this.filas,
            (int) this.columnas
        );

        this.tablero.generarAleatorio();
        
        this.vehiculo = new Moto(tablero);
        this.tablero.usarVehiculo(vehiculo);

        this.salida = new Celda(1, 0);
        this.llegada = new Celda(5, 14);

        this.tablero.iniciarEn(salida);
        this.tablero.finalizarEn(llegada);
    }

    public Tablero getTablero() {
        return this.tablero;
    }

    public Vehiculo getVehiculo() {
        return this.tablero.obtenerVehiculo();
    }

    public Celda getLlegada() {
        return this.llegada;
    }

    public Celda getSalida() {
        return this.salida;
    }

    public void reiniciar() {
        this.tablero.reiniciar();
        this.tablero.generarAleatorio();
        this.tablero.iniciarEn(salida);
        this.tablero.finalizarEn(llegada);
    }

}
