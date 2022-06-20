package edu.fiuba.algo3.integracion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.calle.Calle;
import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.direccion.Direccion;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificador.Modificador;
import edu.fiuba.algo3.modelo.modificador.Piquete;
import edu.fiuba.algo3.modelo.modificador.Pozo;
import edu.fiuba.algo3.modelo.tablero.Tablero;
import edu.fiuba.algo3.modelo.vehiculos.IVehiculo;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.Camioneta4x4;
import edu.fiuba.algo3.modelo.direccion.Derecha;

public class PrimerEntregaTest {
    Tablero tablero = new Tablero(10, 10);
    IVehiculo moto = new Moto();
    Celda celdaInicial = new Celda(0, 0);
    Celda celdaFinal = new Celda(0, 1);
    Direccion direccion = new Derecha();

    public Jugador iniciarConfig(IVehiculo vehiculo, Modificador modificador) {
        this.tablero.reiniciar();
        Jugador jugador = new Jugador(vehiculo);
        
        this.tablero.agregarJugador(jugador);
        this.tablero.iniciarEn(celdaInicial);
        
        // Calle calle = new Calle(this.celdaInicial, this.celdaFinal, modificador);
        this.tablero.agregarModificador(this.celdaInicial, this.celdaFinal, modificador);
        
        // this.celdaInicial.agregarCalle(calle);
        // this.celdaFinal.agregarCalle(calle);
        
        return jugador;
    }

    @Test
    public void unaMotoAtraviesaLaCiudadYSeEncuentraConUnPozoEsPenalizadaEnTresMovimientos() {
        IVehiculo moto = new Moto();
        Modificador pozo = new Pozo();
        
        Jugador jugador = this.iniciarConfig(moto, pozo);
        
        Integer cantMovimientosInicialEsperado = 0;
        Integer cantMovimientosFinalEsperado = 4;
        
        assertEquals(cantMovimientosInicialEsperado, jugador.movimientos());
        
        this.tablero.mover(this.direccion);
        
        assertEquals(cantMovimientosFinalEsperado, jugador.movimientos());
    }

    @Test
    public void unAutoAtraviesaLaCiudadYSeEncuentraConUnPozoEsPenalizadoEnTresMovimientos() {
        IVehiculo auto = new Auto();
        Modificador pozo = new Pozo();

        Jugador jugador = this.iniciarConfig(auto, pozo);

        Integer cantMovimientosInicialEsperado = 0;
        Integer cantMovimientosFinalEsperado = 4;

        assertEquals(cantMovimientosInicialEsperado, jugador.movimientos());

        this.tablero.mover(this.direccion);

        assertEquals(cantMovimientosFinalEsperado, jugador.movimientos());
    }

    @Test
    public void una4X4AtraviesaLaCiudadYSeEncuentraConUnPozoNoEsPenalizada() {
        IVehiculo camioneta4x4 = new Camioneta4x4();
        Modificador pozo = new Pozo();

        Jugador jugador = this.iniciarConfig(camioneta4x4, pozo);

        Integer cantMovimientosInicialEsperado = 0;
        Integer cantMovimientosFinalEsperado = 1;

        assertEquals(cantMovimientosInicialEsperado, jugador.movimientos());

        this.tablero.mover(this.direccion);

        assertEquals(cantMovimientosFinalEsperado, jugador.movimientos());
    }

    // @Test
    // public void unAutoAtraviesaLaCiudadYSeEncuentraConUnPiqueteYNoAvanzaDePosicion() {
    //     IVehiculo auto = new Auto();
    //     Modificador piquete = new Piquete();

    //     Jugador jugador = this.iniciarConfig(auto, piquete);

    //     Integer cantMovimientosInicialEsperado = 0;
    //     Integer cantMovimientosFinalEsperado = 1;
    //     Integer filaFinalEsperada = 0;
    //     Integer columnaFinalEsperada = 0;

    //     assertEquals(cantMovimientosInicialEsperado, jugador.movimientos());

    //     this.tablero.mover(this.direccion);

    //     assertEquals(cantMovimientosFinalEsperado, jugador.movimientos());
    //     assertEquals(filaFinalEsperada, jugador.getPosicion().fila());
    //     assertEquals(columnaFinalEsperada, jugador.getPosicion().columna());
    // }

    // @Test
    // public void una4X4AtraviesaLaCiudadYSeEncuentraConUnPiqueteYNoAvanzaDePosicion() {
    //     IVehiculo camioneta = new Camioneta4x4();
    //     Modificador piquete = new Piquete();

    //     Jugador jugador = this.iniciarConfig(camioneta, piquete);

    //     Integer cantMovimientosInicialEsperado = 0;
    //     Integer cantMovimientosFinalEsperado = 1;
    //     Integer filaFinalEsperada = 0;
    //     Integer columnaFinalEsperada = 0;

    //     assertEquals(cantMovimientosInicialEsperado, jugador.movimientos());

    //     this.tablero.mover(this.direccion);

    //     assertEquals(cantMovimientosFinalEsperado, jugador.movimientos());
    //     assertEquals(filaFinalEsperada, jugador.getPosicion().fila());
    //     assertEquals(columnaFinalEsperada, jugador.getPosicion().columna());
    // }

    @Test
    public void unaMotoAtraviesaLaCiudadYSeEncuentraConUnPiqueteAvanzaDePosicionYPenalizaEnDosMovimientos() {
        IVehiculo moto = new Moto();
        Modificador piquete = new Piquete();

        Jugador jugador = this.iniciarConfig(moto, piquete);

        Integer cantMovimientosInicialEsperado = 0;
        Integer cantMovimientosFinalEsperado = 3;
        Integer filaFinalEsperada = 0;
        Integer columnaFinalEsperada = 1;

        assertEquals(cantMovimientosInicialEsperado, jugador.movimientos());

        this.tablero.mover(this.direccion);

        assertEquals(cantMovimientosFinalEsperado, jugador.movimientos());
        assertEquals(filaFinalEsperada, jugador.getPosicion().fila());
        assertEquals(columnaFinalEsperada, jugador.getPosicion().columna());
    }

}
