package edu.fiuba.algo3.controlador;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.calle.Calle;
import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.direccion.Direccion;
import edu.fiuba.algo3.modelo.registro.Puntaje;
import edu.fiuba.algo3.modelo.tablero.Tablero;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class ControladorJuego implements Observable {

    private Tablero tablero;
    private long filas;
    private long columnas;
    private Vehiculo vehiculo;
    private Celda salida;
    private Celda llegada;

    private ArrayList<Observer> observadores;
    
    public ControladorJuego(long filas, long columnas) {
        this.filas = filas;
        this.columnas = columnas;

        this.tablero = new Tablero(
            (int) this.filas,
            (int) this.columnas
        );

        this.tablero.generarAleatorio();
        
        this.salida = new Celda(1, 0);

        this.observadores = new ArrayList<Observer>();
    }

    @Override
    public void agregar(Observer observer) {
        this.observadores.add(observer);
    }

    @Override
    public void eliminar(Observer observer) {
        this.observadores.remove(observer);
    }

    @Override
    public void notificar() {
        for (Observer observer : this.observadores) {
            observer.update();
        }
    }

    public Tablero getTablero() {
        return this.tablero;
    }

    public Vehiculo getVehiculo() {
        return this.tablero.obtenerVehiculo();
    }

    public int getFilas() {
        return (int) this.filas;
    }

    public int getColumnas() {
        return (int) this.columnas;
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
        this.tablero.finalizarEnCeldaAleatoria();
    }

    public long getMovimientos() {
        return this.tablero.movimientos();
    }

    public Boolean mover(Direccion direccion) {
        Boolean ok = this.tablero.mover(direccion);
        this.vehiculo = this.tablero.obtenerVehiculo();
        
        return ok;
    }

    public Celda obtenerPosicion() {
        return this.tablero.obtenerPosicion();
    }

    public ArrayList<Calle> getCalles() {
        return this.tablero.getCalles();
    }

    public void usarVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
        this.tablero.usarVehiculo(this.vehiculo);
        
        this.tablero.iniciarEn(this.salida);
        this.llegada = this.tablero.finalizarEnCeldaAleatoria();
    }

    // public void registrarPuntaje(String ingreso) {
    //     this.tablero.registrarPuntaje(ingreso);
    // }

    // public ArrayList<Puntaje> getPuntajes() {
    //     return this.tablero.obtenerPuntajes();
    // }

}
