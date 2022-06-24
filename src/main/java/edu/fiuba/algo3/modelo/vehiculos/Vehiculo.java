package edu.fiuba.algo3.modelo.vehiculos;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.direccion.Direccion;
import edu.fiuba.algo3.modelo.modificador.Sorpresa;
import edu.fiuba.algo3.modelo.tablero.Tablero;


public abstract class Vehiculo extends Observable {

    protected Celda celdaInicial;
    protected long movimientos;
    protected Tablero tablero;
    protected Direccion direccionActual;
    protected ArrayList<Observer> observables;

    public Vehiculo(Tablero tablero) {
        this.tablero = tablero;
        this.movimientos = 0;
        this.observables = new ArrayList<Observer>();
    }

    public abstract void reemplazarVehiculo();

    public abstract void pozo();

    public abstract void piquete();

    public abstract void controlPolicial();

    public void sorpresa(Sorpresa sorpresa) {
        this.movimientos = sorpresa.aplicarSorpresa(this.movimientos);
        this.actualizarASiguienteCelda();
    }

    public long movimientos() {
        return this.movimientos;
    }
    
    public Celda getPosicion() {
        return this.celdaInicial;
    }

    public void asignarCeldaInicial(Celda celda) {
        this.celdaInicial = celda;
    }

    public void mover(Direccion direccion) {
        this.movimientos++;
        this.direccionActual = direccion;

        this.celdaInicial.mover(this, direccion);
        this.notificarObservables();
    }

    public void sumarMovimientos(long cantidad) {
        this.movimientos += cantidad;
    }

    public void actualizarASiguienteCelda() {
        this.celdaInicial = this.celdaInicial.buscarSiguiente(this.direccionActual);
    }

    public void notificarObservables() {
        
    }
}