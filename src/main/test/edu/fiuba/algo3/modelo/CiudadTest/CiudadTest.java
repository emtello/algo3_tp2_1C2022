package edu.fiuba.algo3.modelo.CiudadTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import edu.fiuba.algo3.modelo.excepcion.CeldaFueraDeRango;

public class CiudadTest {
    @Test
    public void buscarCeldaOrigenDevueveCeldaCorrectamente() {
        Ciudad generador = new Ciudad(4, 4);

        Celda celda = new Celda(1, 0);

        assertEquals(generador.buscarCelda(celda), celda);
    }

    @Test
    public void buscarCeldaFueraDeRangoDevueveError() {
        Ciudad generador = new Ciudad(3, 3);

        Celda celda = new Celda(5, 5);

        assertThrows(CeldaFueraDeRango.class, () -> generador.buscarCelda(celda));
    }

    @Test
    public void completarCiudadDe10X10DevuelveCiudadCon180Modificadores() {
        Ciudad ciudad = new Ciudad(5, 5);

        ciudad.completarAleatorio();

        assertEquals(24, ciudad.cantidadModificadores());     
    }

}
