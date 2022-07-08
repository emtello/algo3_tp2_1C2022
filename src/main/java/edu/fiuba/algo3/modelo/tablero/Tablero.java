package edu.fiuba.algo3.modelo.tablero;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import edu.fiuba.algo3.modelo.calle.Calle;
import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import edu.fiuba.algo3.modelo.direccion.Direccion;
import edu.fiuba.algo3.modelo.modificador.Modificador;
import edu.fiuba.algo3.modelo.registro.Puntaje;
import edu.fiuba.algo3.modelo.registro.Registro;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class Tablero {
    
    private Vehiculo vehiculo;
    private Ciudad ciudad;
    private Registro registro;
    private int filas;
    private int columnas;

    public Tablero(int filas, int columnas) {
        if (filas < 3 || columnas < 3) {
            throw new IllegalArgumentException(
                    "El tablero debe tener al menos 3 filas y 3 columnas"
            );
        }

        this.ciudad = new Ciudad(filas, columnas);
        this.registro = new Registro();
        this.filas = filas;
        this.columnas = columnas;
    }

    public Celda obtenerPosicion() {
        return this.vehiculo.getPosicion();
    }

    public Vehiculo obtenerVehiculo() {
        return this.vehiculo;
    }

    public long movimientos() {
        return this.vehiculo.movimientos();
    }

    public void iniciarEn(Celda celda) {
        Celda celdaInicial = this.ciudad.iniciaEn(celda);

        this.vehiculo.asignarCeldaInicial(celdaInicial);
    }

    public Celda finalizarEnCeldaAleatoria() {
        return this.ciudad.finalizarEnCeldaAleatoria();
    } 

    public Celda finalizarEn(Celda celda) {
        return this.ciudad.finalizaEn(celda);
    }

    public void agregarModificador(Celda ini, Celda fin, Modificador mod) {
        // this.ciudad.agregarModificador(ini, fin, mod);
        this.ciudad.agregarModificador(ini, fin, mod);
    }

    public void generarAleatorio() {
        // this.ciudad.completarAleatorio();
        this.ciudad.completarAleatorio();
    }

    public void usarVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Boolean mover(Direccion direccion) {
        this.vehiculo.mover(direccion);

        return this.vehiculo.estaEn(this.ciudad.getLlegada());
    }

    public int getFilas() {
        return this.filas;
    }

    public int getColumnas() {
        return this.columnas;
    }

    public void reemplazarVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void reiniciar() {
        this.ciudad.reiniciar();
        this.ciudad.completarAleatorio();
        this.vehiculo.asignarCeldaInicial(
            this.ciudad.getInicio()
        );
    }

    public void registrarPuntaje() {
        Puntaje puntaje = new Puntaje("usuario", this.vehiculo.movimientos());
        this.registro.cargarPuntaje(puntaje);
    }

    public ArrayList<Calle> getCalles() {
        return this.ciudad.getCalles();
    }

}



