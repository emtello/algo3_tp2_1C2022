package edu.fiuba.algo3.modelo.registro;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PuntajeTest {
    @Test
    public void comprarDosPuntajesDistintosDevuelveMenos1() {
        Puntaje unPuntaje = new Puntaje("usuario1", 10);
        Puntaje otroPuntaje = new Puntaje("usuario2", 15);

        assertEquals(-1, unPuntaje.compareTo(otroPuntaje));
    }

    @Test
    public void comprarDosPuntajesIgualesDevuelve0() {
        Puntaje unPuntaje = new Puntaje("usuario1", 10);
        Puntaje otroPuntaje = new Puntaje("usuario2", 10);

        assertEquals(0, unPuntaje.compareTo(otroPuntaje));
    }

    @Test
    public void comprarDosPuntajesDistintosDevuelve1() {
        Puntaje unPuntaje = new Puntaje("usuario1", 15);
        Puntaje otroPuntaje = new Puntaje("usuario2", 10);

        assertEquals(1, unPuntaje.compareTo(otroPuntaje));
    }
}