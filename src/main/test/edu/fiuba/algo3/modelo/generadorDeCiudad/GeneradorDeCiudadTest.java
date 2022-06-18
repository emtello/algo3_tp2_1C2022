package edu.fiuba.algo3.modelo.generadorDeCiudad;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.excepcion.CeldaFueraDeRango;

public class GeneradorDeCiudadTest {
    @Test
    public void buscarCeldaOrigenDevueveCeldaCorrectamente() {
        GeneradorDeCiudad generador = new GeneradorDeCiudad(4, 4);

        Celda celda = new Celda(0, 0);

        assertEquals(generador.buscarCelda(celda), celda);
    }

    @Test
    public void buscarCeldaFueraDeRangoDevueveError() {
        GeneradorDeCiudad generador = new GeneradorDeCiudad(2, 2);

        Celda celda = new Celda(5, 5);

        assertThrows(CeldaFueraDeRango.class, () -> generador.buscarCelda(celda));
    }
}
