package edu.fiuba.algo3.integracion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.direccion.Direccion;
import edu.fiuba.algo3.modelo.modificador.Modificador;
import edu.fiuba.algo3.modelo.modificador.Piquete;
import edu.fiuba.algo3.modelo.modificador.Pozo;
import edu.fiuba.algo3.modelo.tablero.Tablero;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.Camioneta4x4;
import edu.fiuba.algo3.modelo.direccion.Derecha;

public class PrimerEntregaTest {
    Tablero tablero = new Tablero(10, 10);
    Vehiculo moto = new Moto(this.tablero);
    Celda celdaInicial = new Celda(0, 0);
    Celda celdaFinal = new Celda(0, 1);
    Direccion direccion = new Derecha();

    public void iniciarConfig(Vehiculo vehiculo, Modificador modificador) {
        this.tablero.agregarvehiculo(vehiculo);
        this.tablero.iniciarEn(celdaInicial);
        
        this.tablero.agregarModificador(this.celdaInicial, this.celdaFinal, modificador);
    }

    @Test
    public void unaMotoAtraviesaLaCiudadYSeEncuentraConUnPozoEsPenalizadaEnTresMovimientos() {
        Vehiculo moto = new Moto(this.tablero);
        Modificador pozo = new Pozo();
        
        this.iniciarConfig(moto, pozo);
        
        long cantMovimientosInicialEsperado = 0;
        long cantMovimientosFinalEsperado = 4;
        
        assertEquals(cantMovimientosInicialEsperado, moto.movimientos());
        
        this.tablero.mover(this.direccion);
        
        assertEquals(cantMovimientosFinalEsperado, moto.movimientos());
    }

    @Test
    public void unAutoAtraviesaLaCiudadYSeEncuentraConUnPozoEsPenalizadoEnTresMovimientos() {
        Vehiculo auto = new Auto(this.tablero);
        Modificador pozo = new Pozo();

        this.iniciarConfig(auto, pozo);

        long cantMovimientosInicialEsperado = 0;
        long cantMovimientosFinalEsperado = 4;

        assertEquals(cantMovimientosInicialEsperado, auto.movimientos());

        this.tablero.mover(this.direccion);

        assertEquals(cantMovimientosFinalEsperado, auto.movimientos());
    }

    
    @Test
    public void una4X4AtraviesaLaCiudadYSeEncuentraConUnPozoNoEsPenalizada() {
        Vehiculo camioneta4x4 = new Camioneta4x4(this.tablero);
        Modificador pozo = new Pozo();

        this.iniciarConfig(camioneta4x4, pozo);

        long cantMovimientosInicialEsperado = 0;
        long cantMovimientosFinalEsperado = 1;

        assertEquals(cantMovimientosInicialEsperado, camioneta4x4.movimientos());

        this.tablero.mover(this.direccion);

        assertEquals(cantMovimientosFinalEsperado, camioneta4x4.movimientos());
    }

    @Test
    public void unAutoAtraviesaLaCiudadYSeEncuentraConUnPiqueteYNoAvanzaDePosicion() {
        Vehiculo auto = new Auto(this.tablero);
        Modificador piquete = new Piquete();

        iniciarConfig(auto, piquete);

        long cantMovimientosInicialEsperado = 0;
        long cantMovimientosFinalEsperado = 1;
        long filaFinalEsperada = 0;
        long columnaFinalEsperada = 0;

        assertEquals(cantMovimientosInicialEsperado, auto.movimientos());

        this.tablero.mover(this.direccion);

        assertEquals(cantMovimientosFinalEsperado, auto.movimientos());
        assertEquals(filaFinalEsperada, auto.getPosicion().fila());
        assertEquals(columnaFinalEsperada, auto.getPosicion().columna());
    }

    @Test
    public void una4X4AtraviesaLaCiudadYSeEncuentraConUnPiqueteYNoAvanzaDePosicion() {
        Vehiculo camioneta = new Camioneta4x4(this.tablero);
        Modificador piquete = new Piquete();

        this.iniciarConfig(camioneta, piquete);

        long cantMovimientosInicialEsperado = 0;
        long cantMovimientosFinalEsperado = 1;
        long filaFinalEsperada = 0;
        long columnaFinalEsperada = 0;

        assertEquals(cantMovimientosInicialEsperado, camioneta.movimientos());

        this.tablero.mover(this.direccion);

        assertEquals(cantMovimientosFinalEsperado, camioneta.movimientos());
        assertEquals(filaFinalEsperada, camioneta.getPosicion().fila());
        assertEquals(columnaFinalEsperada, camioneta.getPosicion().columna());
    }

    @Test
    public void unaMotoAtraviesaLaCiudadYSeEncuentraConUnPiqueteAvanzaDePosicionYPenalizaEnDosMovimientos() {
        Vehiculo moto = new Moto(this.tablero);
        Modificador piquete = new Piquete();

        this.iniciarConfig(moto, piquete);

        long cantMovimientosInicialEsperado = 0;
        long cantMovimientosFinalEsperado = 3;
        long filaFinalEsperada = 0;
        long columnaFinalEsperada = 1;

        assertEquals(cantMovimientosInicialEsperado, moto.movimientos());

        this.tablero.mover(this.direccion);

        assertEquals(cantMovimientosFinalEsperado, moto.movimientos());
        assertEquals(filaFinalEsperada, moto.getPosicion().fila());
        assertEquals(columnaFinalEsperada, moto.getPosicion().columna());
    }

}
