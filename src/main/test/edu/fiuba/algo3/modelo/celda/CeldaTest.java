package edu.fiuba.algo3.modelo.celda;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.vehiculos.Moto;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.calle.Calle;
import edu.fiuba.algo3.modelo.direccion.Abajo;
import edu.fiuba.algo3.modelo.direccion.Arriba;
import edu.fiuba.algo3.modelo.direccion.Derecha;
import edu.fiuba.algo3.modelo.direccion.Izquierda;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class CeldaTest {

    private Integer fila = 1;
    private Integer columna = 1;
    
    Calle calleMock = mock(Calle.class);
    Calle calleMock2 = mock(Calle.class);
    Calle calleMock3 = mock(Calle.class);
    Calle calleMock4 = mock(Calle.class);

    private void mockearCeldas() {
        when(calleMock.siguienteEsquina(any(Celda.class)))
        .thenReturn(new Celda(fila - 1, columna));
        when(calleMock.contiene(any(Celda.class)))
        .thenReturn(true);

        when(calleMock2.siguienteEsquina(any(Celda.class)))
        .thenReturn(new Celda(fila + 1, columna));
        when(calleMock2.contiene(any(Celda.class)))
        .thenReturn(true);
        
        when(calleMock3.siguienteEsquina(any(Celda.class)))
        .thenReturn(new Celda(fila, columna + 1));
        when(calleMock3.contiene(any(Celda.class)))
        .thenReturn(true);

        when(calleMock4.siguienteEsquina(any(Celda.class)))
        .thenReturn(new Celda(fila, columna - 1));
        when(calleMock4.contiene(any(Celda.class)))
        .thenReturn(true);
    }

    private void agregarCallesAleatoriamente(Celda celda) {
        ArrayList<Calle> calles = new ArrayList<Calle>();

        calles.add(calleMock);
        calles.add(calleMock2);
        calles.add(calleMock3);
        calles.add(calleMock4);

        for (int i = 0; i < calles.size(); i++) {
            int randomIndexToSwap = (int) (Math.random() * calles.size());
            Calle calleTemp = calles.get(i);
            calles.set(i, calles.get(randomIndexToSwap));
            calles.set(randomIndexToSwap, calleTemp);
        }

        for (Calle calle : calles) {
            celda.agregarCalle(calle);
        }
    }

    @Test
    public void celdaMoverHaciaArribaDevuelveUnaCeldaConFilaDecrementadaEn1YMismaColumna() {
        Celda celda = new Celda(fila, columna);
        
        this.mockearCeldas();
        this.agregarCallesAleatoriamente(celda);
        
        Jugador jugador = new Jugador(new Moto());
        jugador.asignarCeldaInicial(celda);
        
        Celda celdaMovida = celda.mover(jugador, new Arriba());
        
        assertEquals(0, celdaMovida.fila());
        assertEquals(1, celdaMovida.columna());
    }

    @Test
    public void celdaMoverHaciaAbajoDevuelveUnaCeldaConFilaIncrementadaEn1YMismaColumna() {
        Celda celda = new Celda(fila, columna);
        
        this.mockearCeldas();
        this.agregarCallesAleatoriamente(celda);

        Jugador jugador = new Jugador(new Moto());
        jugador.asignarCeldaInicial(celda);

        Celda celdaMovida = celda.mover(jugador, new Abajo());

        assertEquals(2, celdaMovida.fila());
        assertEquals(1, celdaMovida.columna());
    }

    @Test
    public void celdaMoverHaciaDerechaDevuelveUnaCeldaConColumnaIncrementadaEn1YMismaFila() {
        Celda celda = new Celda(fila, columna);
        
        this.mockearCeldas();
        this.agregarCallesAleatoriamente(celda);

        Jugador jugador = new Jugador(new Moto());
        jugador.asignarCeldaInicial(celda);

        Celda celdaMovida = celda.mover(jugador, new Derecha());

        assertEquals(2, celdaMovida.columna());
        assertEquals(1, celdaMovida.fila());
    }

    @Test
    public void celdaMoverHaciaIzquierdaDevuelveUnaCeldaConColumnaDecrementadaEn1YMismaFila() {
        Celda celda = new Celda(fila, columna);

        this.mockearCeldas();
        this.agregarCallesAleatoriamente(celda);
        
        Jugador jugador = new Jugador(new Moto());
        jugador.asignarCeldaInicial(celda);
        Celda celdaMovida = celda.mover(jugador, new Izquierda());

        assertEquals(0, celdaMovida.columna());
        assertEquals(1, celdaMovida.fila());
    }

    @Test
    public void agregarMasDeCuatroCallesDevuelveError() {
        Celda celda = new Celda(fila, columna);

        this.mockearCeldas();
        this.agregarCallesAleatoriamente(celda);

        Calle nuevaCalle = mock(Calle.class);
        
        assertThrows(Error.class, () -> celda.agregarCalle(nuevaCalle));
    }


}
