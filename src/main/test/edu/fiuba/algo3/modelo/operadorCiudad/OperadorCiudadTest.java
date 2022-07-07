package edu.fiuba.algo3.modelo.operadorCiudad;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import edu.fiuba.algo3.modelo.direccion.Abajo;
import edu.fiuba.algo3.modelo.direccion.Derecha;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OperadorCiudadTest {
    
    @Test
    public void dosCeldasQueTienenLaMismaEsquinaComoAdyacenciaDebenTenerLaMismaInstanciaDeLaEsquina() {
        long f = 4;
        long c = 4;

        Ciudad ciudad = new Ciudad((int) f, (int) c);
        Celda celdaInicial = new Celda(1, 1);
        OperadorCiudad operadorCiudad = new OperadorCiudad(celdaInicial);
        operadorCiudad.generarCaminos(ciudad, f, c);

        Celda celda12 = ciudad.buscarCelda(new Celda(1, 2));
        Celda celda22 = celda12.buscarSiguiente(new Abajo());

        Celda celda21 = ciudad.buscarCelda(new Celda(2, 1));
        Celda celda22_ = celda21.buscarSiguiente(new Derecha());

        Celda celda22_real = ciudad.buscarCelda(new Celda(2, 2));

        // Verificar que celda22_ y celda22 son la misma instancia
        assertTrue(celda22_ == celda22_real);
        assertTrue(celda22 == celda22_real);
        assertTrue(celda22 == celda22_);

    }

}
