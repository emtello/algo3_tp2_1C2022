package edu.fiuba.algo3.modelo.modificador;

import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DesfavorableTest {

    @Test
    void cruzarCon() {
    }

    @Test
    void aplicarSorpresa() {
    }

    @Test
    void  modificadorFavorableSeCruzaConJugador() {
        //Arrange
        Desfavorable modificadorDesfavorable = new Desfavorable();
        Celda celda = new Celda(0, 0);
        Moto moto = new Moto();
        Jugador jugador = new Jugador(moto);
        jugador.asignarCeldaInicial(celda);

        jugador.sumarMovimientos(10);

        //Act
        modificadorDesfavorable.cruzarCon(jugador);
        //Assert
        assertEquals(Math.round((10 * 1.25)+1), jugador.movimientos()); //Suma el 25% de los movimientos hechos + 1 movimiento
    }
}