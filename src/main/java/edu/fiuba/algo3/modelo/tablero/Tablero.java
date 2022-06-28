package edu.fiuba.algo3.modelo.tablero;

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
    private Celda llegada;
    private Registro registro;

    public Tablero(int filas, int columnas) {
        if (filas < 3 || columnas < 3) {
            throw new IllegalArgumentException(
                "El tablero debe tener al menos 3 filas y 3 columnas"
            );
        }

        this.ciudad = new Ciudad(filas, columnas);
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
        Celda inicio = this.ciudad.buscarCelda(celda);
        this.vehiculo.asignarCeldaInicial(inicio);
    }

    public void finalizarEn(Celda celda) {
        this.llegada = celda;
    }

    public void agregarModificador(Celda ini, Celda fin, Modificador mod) {
        this.ciudad.agregarModificador(ini, fin, mod);
    }

    public void generarAleatorio() {
        this.ciudad.completarAleatorio();
    }

    public void usarVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Boolean mover(Direccion direccion) {
        this.vehiculo.mover(direccion);

        return this.vehiculo.estaEn(this.llegada);
    }

    public void reemplazarVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void reiniciar() {
        this.ciudad.reiniciar();
    }

    public void registrarPuntaje() {
        Puntaje puntaje = new Puntaje("usuario", this.vehiculo.movimientos());
        this.registro.cargarPuntaje(puntaje);
    }

}
