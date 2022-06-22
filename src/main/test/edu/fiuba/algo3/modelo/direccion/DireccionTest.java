package edu.fiuba.algo3.modelo.direccion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.excepcion.CeldaFueraDeRango;

public class DireccionTest {
    
    Celda celdaActual = new Celda(1, 1);
    Celda esquina1 = new Celda(0, 1);
    Celda esquina2 = new Celda(2, 1);
    Celda esquina3 = new Celda(1, 0);
    Celda esquina4 = new Celda(1, 2);
    ArrayList<Celda> listaCeldasVacia = new ArrayList<Celda>();

    private ArrayList<Celda> esquinasMezcladas() {
        ArrayList<Celda> esquinas = new ArrayList<Celda>();
        esquinas.add(esquina1);
        esquinas.add(esquina2);
        esquinas.add(esquina3);
        esquinas.add(esquina4);

        for (int i = 0; i < esquinas.size(); i++) {
            int randomIndexToSwap = (int) (Math.random() * esquinas.size());
            Celda esquinaTemp = esquinas.get(i);
            esquinas.set(i, esquinas.get(randomIndexToSwap));
            esquinas.set(randomIndexToSwap, esquinaTemp);
        }

        return esquinas;
    }

    @Test
    public void arribaMoverDevuelveLaEsquinaConFilaQueEstaDecrementadaEn1YMismaColumna() {
        Direccion direccion = new Arriba();
        
        Celda celdaAMoverse = direccion.mover(
            celdaActual.fila(),
            celdaActual.columna(),
            this.esquinasMezcladas()
        );

        assertEquals(celdaAMoverse.fila(), celdaActual.fila() - 1);
        assertEquals(celdaAMoverse.columna(), celdaActual.columna());
    }

    @Test
    public void abajoMoverDevuelveLaEsquinaConFilaQueEstaIncrementadaEn1YMismaColumna() {
        Direccion direccion = new Abajo();
        
        Celda celdaAMoverse = direccion.mover(
            celdaActual.fila(),
            celdaActual.columna(),
            this.esquinasMezcladas()
        );

        assertEquals(celdaAMoverse.fila(), celdaActual.fila() + 1);
        assertEquals(celdaAMoverse.columna(), celdaActual.columna());
    }

    @Test
    public void izquierdaMoverDevuelveLaEsquinaConColumnaQueEstaDecrementadaEn1YMismaFila() {
        Direccion direccion = new Izquierda();
        
        Celda celdaAMoverse = direccion.mover(
            celdaActual.fila(),
            celdaActual.columna(),
            this.esquinasMezcladas()
        );

        assertEquals(celdaAMoverse.fila(), celdaActual.fila());
        assertEquals(celdaAMoverse.columna(), celdaActual.columna() - 1);
    }

    @Test
    public void derechaMoverDevuelveLaEsquinaConColumnaQueEstaIncrementadaEn1YMismaFila() {
        Direccion direccion = new Derecha();
        
        Celda celdaAMoverse = direccion.mover(
            celdaActual.fila(),
            celdaActual.columna(),
            this.esquinasMezcladas()
        );

        assertEquals(celdaAMoverse.fila(), celdaActual.fila());
        assertEquals(celdaAMoverse.columna(), celdaActual.columna() + 1);
    }

    @Test
    public void moverALaIzquierdaSinCallePosibleDevuelveNull() {
        Direccion direccion = new Izquierda();

        assertThrows(CeldaFueraDeRango.class, () -> {
            direccion.mover(
                celdaActual.fila(),
                celdaActual.columna(),
                this.listaCeldasVacia
            );
        });

    }

    @Test
    public void moverALaArribaSinCallePosibleDevuelveNull() {
        Direccion direccion = new Arriba();
        
        assertThrows(CeldaFueraDeRango.class, () -> {
            direccion.mover(
                celdaActual.fila(),
                celdaActual.columna(),
                this.listaCeldasVacia
            );
        });
    }

    @Test
    public void moverALaAbajoSinCallePosibleDevuelveNull() {
        Direccion direccion = new Abajo();

        assertThrows(CeldaFueraDeRango.class, () -> {
            direccion.mover(
                celdaActual.fila(),
                celdaActual.columna(),
                this.listaCeldasVacia
            );
        });
    }

    @Test
    public void moverALaDerechaSinCallePosibleDevuelveNull() {
        Direccion direccion = new Derecha();

        assertThrows(CeldaFueraDeRango.class, () -> {
            direccion.mover(
                celdaActual.fila(),
                celdaActual.columna(),
                this.listaCeldasVacia
            );
        });
    }


}
