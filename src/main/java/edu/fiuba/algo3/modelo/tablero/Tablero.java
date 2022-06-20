package edu.fiuba.algo3.modelo.tablero;

import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.direccion.Direccion;
import edu.fiuba.algo3.modelo.generadorDeCiudad.GeneradorDeCiudad;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificador.Modificador;

public class Tablero {
    
    private Jugador jugador;
    private GeneradorDeCiudad generador;

    public Tablero(int filas, int columnas) {
        this.generador = new GeneradorDeCiudad(filas, columnas);
    }

    public void iniciarEn(Celda celda) {
        Celda inicio = this.generador.buscarCelda(celda);
        this.jugador.asignarCeldaInicial(inicio);
    }

    public void agregarJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public void mover(Direccion direccion) {
        this.jugador.mover(direccion);
    }

    public Celda obtenerPosicion() {
        return this.jugador.getPosicion();
    }

    public void agregarModificador(Celda origen, Celda destino, Modificador mod) {
        this.generador.agregarModificador(origen, destino, mod);
    }

    public void reiniciar() {
        this.generador.reiniciar();
    }

}
