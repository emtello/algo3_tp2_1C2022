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
    protected ArrayList<Observer> observadores;

    protected String nombre;

    public Vehiculo(Tablero tablero) {
        this.tablero = tablero;
        this.movimientos = 0;
        this.observadores = new ArrayList<Observer>();
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
    }

    public void sumarMovimientos(long cantidad) {
        this.movimientos += cantidad;
    }

    public void actualizarASiguienteCelda() {
        this.celdaInicial = this.celdaInicial.buscarSiguiente(this.direccionActual);
        // this.notificarObservables();
    }

    @Override
    public synchronized void addObserver(Observer o) {
        this.observadores.add(o);
    }

    public void notificarObservables() {
        for (Observer observer : this.observadores) {
            observer.update(this, this.getPosicion());
        }   
    }

    public String getNombre() {
        return this.nombre;
    }
}