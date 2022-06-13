package edu.fiuba.algo3.modelo.modificador;

import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificador.Nulo;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.Camioneta4x4;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NuloTest {

    @Test
    public void modificadorNuloSeCruzaConJugadorConMotoYSumaUnMovimiento() {

        Nulo nulo = new Nulo();
        Celda celda = new Celda(0, 0);
        Moto moto = new Moto();
        Jugador jugador = new Jugador(moto);
        jugador.asignarCeldaInicial(celda);

        nulo.cruzarCon(jugador);

        assertEquals(1, jugador.movimientos());

    }

    @Test
    public void modificadorNuloSeCruzaConJugadorConAutoYSumaUnMovimiento() {

        Nulo nulo = new Nulo();
        Celda celda = new Celda(0, 0);
        Auto auto = new Auto();
        Jugador jugador = new Jugador(auto);
        jugador.asignarCeldaInicial(celda);

        nulo.cruzarCon(jugador);

        assertEquals(1, jugador.movimientos());

    }

    @Test
    public void modificadorNuloSeCruzaConJugadorConCamionetaYSumaUnMovimiento() {

        Nulo nulo = new Nulo();
        Celda celda = new Celda(0, 0);
        Camioneta4x4 camioneta = new Camioneta4x4();
        Jugador jugador = new Jugador(camioneta);
        jugador.asignarCeldaInicial(celda);

        nulo.cruzarCon(jugador);

        assertEquals(1, jugador.movimientos());

    }

}