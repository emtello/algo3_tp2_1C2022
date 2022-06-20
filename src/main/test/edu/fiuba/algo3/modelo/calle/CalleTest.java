package edu.fiuba.algo3.modelo.calle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.modificador.Modificador;
import edu.fiuba.algo3.modelo.modificador.Nulo;
import edu.fiuba.algo3.modelo.modificador.Pozo;

public class CalleTest {
    
    @Test
    public void agregoDosCeldasAUnaCalleYVerificoQueLasContenga() {
        Celda primerCelda = new Celda(0, 0);
        Celda segundaCelda = new Celda(0, 1);

        Calle calle = new Calle(primerCelda, segundaCelda, new Pozo());

        assertEquals(calle.contiene(primerCelda), true);
        assertEquals(calle.contiene(segundaCelda), true);
    }

    @Test
    public void agregoDosCeldasAUnaCalleYObtengoLaSiguienteESquina() {
        Celda primerCelda = new Celda(0, 0);
        Celda segundaCelda = new Celda(0, 1);

        Calle calle = new Calle(primerCelda, segundaCelda, new Pozo());

        assertEquals(calle.siguienteEsquina(primerCelda), segundaCelda);
    }

    @Test
    public void borrarModificadorCambiaElAtributoANulo() {
        Celda primerCelda = new Celda(0, 0);
        Celda segundaCelda = new Celda(0, 1);
        Modificador mod = mock(Modificador.class);

        Calle calle = new Calle(primerCelda, segundaCelda, mod);
        calle.borrarModificadores();

        assertEquals(Nulo.class, calle.getModificador().getClass());
    }

    @Test
    public void agregarModificadorCambiaElAtributoAlModificadorCorrecto() {
        Celda primerCelda = new Celda(0, 0);
        Celda segundaCelda = new Celda(0, 1);
        Modificador mod = mock(Modificador.class);



        Calle calle = new Calle(primerCelda, segundaCelda, mod);
        calle.agregarModificador(new Pozo());

        assertEquals(Pozo.class, calle.getModificador().getClass());
    }

}
