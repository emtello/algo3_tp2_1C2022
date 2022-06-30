package edu.fiuba.algo3.modelo.tablero;

import java.util.Observable;
import java.util.Observer;

import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.direccion.Direccion;
import edu.fiuba.algo3.modelo.generadorDeCiudad.GeneradorDeCiudad;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;
import edu.fiuba.algo3.modelo.modificador.Modificador;
import edu.fiuba.algo3.modelo.registro.Registro;
import edu.fiuba.algo3.modelo.registro.Puntaje;


public class Tablero extends Observable {
    
    private Vehiculo vehiculo;
    private GeneradorDeCiudad generador;
    private Registro registro;
    private int filas;
    private int columnas;

    public Tablero(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.generador = new GeneradorDeCiudad(filas, columnas);
    }

    public void iniciarEn(Celda celda) {
        celda = this.generador.buscarCelda(celda);
        this.vehiculo.asignarCeldaInicial(celda);
    }

    public void agregarvehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void mover(Direccion direccion) {
        this.vehiculo.mover(direccion);
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

    public int getFilas() {
        return this.filas;
    }

    public int getColumnas() {
        return this.columnas;
    }

    public void agregarModificador(Celda origen, Celda destino, Modificador mod) {
        this.generador.agregarModificador(origen, destino, mod);
    }

    public void reiniciar() {
        this.generador.reiniciar();
    }

    public void registrarPuntaje() {
        Puntaje puntaje = new Puntaje("usuario", this.vehiculo.movimientos());
        this.registro.cargarPuntaje(puntaje);
    }
    
    public void notificarObservadores() {
        this.vehiculo.notificarObservables();
    }

}
