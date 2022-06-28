package edu.fiuba.algo3.modelo.modificador;

import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.direccion.Direccion;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.Camioneta4x4;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PiqueteTest extends ModificadorTest {

    @Test
    public void modificadorPiqueteSeCruzarConMotoAtraviezaYEsPenalizadoCon2() {

        Piquete piquete = new Piquete();

        Celda celdaMock = mock(Celda.class);
        when(celdaMock.buscarSiguiente(any(Direccion.class)))
                .thenReturn(new Celda(0, 0));

        Vehiculo moto = new Moto(this.tablero);

        moto.asignarCeldaInicial(celdaMock);

        piquete.cruzarCon(moto);

        assertEquals(2, moto.movimientos());
    }

    @Test
    public void modificadorPiqueteSeCruzarConAutoNoAtraviezaYNoEsPenalizado() {

        Piquete piquete = new Piquete();

        Celda celdaMock = mock(Celda.class);
        when(celdaMock.buscarSiguiente(any(Direccion.class)))
                .thenReturn(new Celda(0, 0));

        Vehiculo auto = new Auto(this.tablero);

        auto.asignarCeldaInicial(celdaMock);

        piquete.cruzarCon(auto);

        assertEquals(0, auto.movimientos());

    }

    @Test
    public void modificadorPiqueteSeCruzarConCamionetaNoAtraviezaYNoEsPenalizado() {

        Piquete piquete = new Piquete();

        Celda celdaMock = mock(Celda.class);
        when(celdaMock.buscarSiguiente(any(Direccion.class)))
                .thenReturn(new Celda(0, 0));

        Vehiculo camioneta = new Camioneta4x4(this.tablero);

        camioneta.asignarCeldaInicial(celdaMock);

        piquete.cruzarCon(camioneta);

        assertEquals(0, camioneta.movimientos());

    }
}