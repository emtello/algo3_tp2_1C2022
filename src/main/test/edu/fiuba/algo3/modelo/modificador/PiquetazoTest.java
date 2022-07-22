package edu.fiuba.algo3.modelo.modificador;

import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.direccion.Direccion;
import edu.fiuba.algo3.modelo.vehiculos.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PiquetazoTest extends ModificadorTest {

    @Test
    public void modificadorPiquetazoSeCruzaConMotoNoAtraviezaYEsPenalizadoCon2() {
        Piquetazo piquetazo = new Piquetazo();

        Celda celdaMock = mock(Celda.class);
        when(celdaMock.buscarSiguiente(any(Direccion.class)))
                .thenReturn(new Celda(0, 0));

        Vehiculo moto = new Moto(this.tablero);

        moto.asignarCeldaInicial(celdaMock);

        piquetazo.cruzarCon(moto);

        assertEquals(2, moto.movimientos());
    }

    @Test
    public void modificadorPiquetazoSeCruzaConAutoNoAtraviezaYEsPenalizadoCon2() {
        Piquetazo piquetazo = new Piquetazo();

        Celda celdaMock = mock(Celda.class);
        when(celdaMock.buscarSiguiente(any(Direccion.class)))
                .thenReturn(new Celda(0, 0));

        Vehiculo auto = new Auto(this.tablero);

        auto.asignarCeldaInicial(celdaMock);

        piquetazo.cruzarCon(auto);

        assertEquals(2, auto.movimientos());
    }

    @Test
    public void modificadorPiquetazoSeCruzaCon4x4NoAtraviezaYEsPenalizadoCon4() {
        Piquetazo piquetazo = new Piquetazo();

        Celda celdaMock = mock(Celda.class);
        when(celdaMock.buscarSiguiente(any(Direccion.class)))
                .thenReturn(new Celda(0, 0));

        Vehiculo camioneta = new Camioneta4x4(this.tablero);

        camioneta.asignarCeldaInicial(celdaMock);

        piquetazo.cruzarCon(camioneta);

        assertEquals(4, camioneta.movimientos());
    }

    @Test
    public void modificadorPiquetazoSeCruzaConReliantRobinNoAtraviezaYEsPenalizadoCon2() {
        Piquetazo piquetazo = new Piquetazo();

        Celda celdaMock = mock(Celda.class);
        when(celdaMock.buscarSiguiente(any(Direccion.class)))
                .thenReturn(new Celda(0, 0));

        Vehiculo reliant = new ReliantRobin(this.tablero);

        reliant.asignarCeldaInicial(celdaMock);

        piquetazo.cruzarCon(reliant);

        assertEquals(2, reliant.movimientos());
    }
}
