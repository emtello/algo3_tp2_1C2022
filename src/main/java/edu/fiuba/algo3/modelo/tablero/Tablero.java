package edu.fiuba.algo3.modelo.tablero;

import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.direccion.Direccion;
import edu.fiuba.algo3.modelo.generadorDeCiudad.GeneradorDeCiudad;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;
import edu.fiuba.algo3.modelo.modificador.Modificador;

public class Tablero {
    
    private Vehiculo vehiculo;
    private GeneradorDeCiudad generador;
    private Celda llegada;

    public Tablero(int filas, int columnas) {
        this.generador = new GeneradorDeCiudad(filas, columnas);
    }

    public void iniciarEn(Celda celda) {
        Celda inicio = this.generador.buscarCelda(celda);
        this.vehiculo.asignarCeldaInicial(inicio);
    }

    public void agregarvehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Boolean mover(Direccion direccion) {
        this.vehiculo.mover(direccion);

        return this.vehiculo.estaEn(this.llegada);
    }

    public void asignarLlegada(Celda celda) {
        this.llegada = celda;
    }

    public long movimientos() {
        return this.vehiculo.movimientos();
    }

    public void reemplazarVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Celda obtenerPosicion() {
        return this.vehiculo.getPosicion();
    }

    public Vehiculo getVehiculo() {
        return this.vehiculo;
    }

    public void agregarModificador(Celda origen, Celda destino, Modificador mod) {
        this.generador.agregarModificador(origen, destino, mod);
    }

    public void reiniciar() {
        this.generador.reiniciar();
    }

}
