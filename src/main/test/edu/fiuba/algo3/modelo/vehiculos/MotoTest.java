package edu.fiuba.algo3.modelo.vehiculos;

import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.direccion.Direccion;
import edu.fiuba.algo3.modelo.modificador.CambioDeVehiculo;
import edu.fiuba.algo3.modelo.modificador.ControlPolicial;
import edu.fiuba.algo3.modelo.modificador.Piquete;
import edu.fiuba.algo3.modelo.modificador.Pozo;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


public class MotoTest extends VehiculoTest {

    @Test
    public void motoAplicaModificadorPozoYEsPenalizadoCon3Movimientos() {

        Pozo pozo = new Pozo();

        Celda celdaMock = mock(Celda.class);
        when(celdaMock.buscarSiguiente(any(Direccion.class)))
                .thenReturn(new Celda(0, 0));

        Vehiculo moto = new Moto(this.tablero);

        moto.asignarCeldaInicial(celdaMock);

        moto.aplicarModificador(pozo);

        assertEquals(3, moto.movimientos());
    }

    @Test
    public void motoAplicaModificadorCambioDeVehiculoYCambiaPorAuto() {

        CambioDeVehiculo cambioDeVehiculo = new CambioDeVehiculo();

        Celda celdaMock = mock(Celda.class);
        when(celdaMock.buscarSiguiente(any(Direccion.class)))
                .thenReturn(new Celda(0, 0));

        Vehiculo moto = new Moto(this.tablero);

        moto.asignarCeldaInicial(celdaMock);

        moto.aplicarModificador(cambioDeVehiculo);

        assertEquals(Auto.class, this.tablero.obtenerVehiculo().getClass());

    }

    @Test
    public void motoAplicaModificadorPiqueteAtraviezaYEsPenalizadoCon2() {

        Piquete piquete = new Piquete();

        Celda celdaMock = mock(Celda.class);
        when(celdaMock.buscarSiguiente(any(Direccion.class)))
                .thenReturn(new Celda(0, 0));

        Vehiculo moto = new Moto(this.tablero);

        moto.asignarCeldaInicial(celdaMock);

        moto.aplicarModificador(piquete);

        assertEquals(2, moto.movimientos());

    }

    /*    @Test
    public void motoAplicaModificadorControlPoliciaEsPenalizadoCon3() {

        ControlPolicial controlPolicial = new ControlPolicial();

        Celda celdaMock = mock(Celda.class);
        when(celdaMock.buscarSiguiente(any(Direccion.class)))
                .thenReturn(new Celda(0, 0));

        Vehiculo moto = new Moto(this.tablero);

        moto.asignarCeldaInicial(celdaMock);

        moto.aplicarModificador(controlPolicial);

        assertEquals(3, moto.movimientos());

    }*/

    @Test
    public void motoAplicaModificadorControlPoliciaCuandoNoSuperaProbabilidadEsPenalizadoCon3() {

        ControlPolicial controlPolicial = new ControlPolicial();

        Celda celdaMock = mock(Celda.class);
        when(celdaMock.buscarSiguiente(any(Direccion.class)))
                .thenReturn(new Celda(0, 0));

        Random randomMock = mock(Random.class);
        when(randomMock.nextFloat())
                .thenReturn(0.8f);

        Vehiculo moto = new Moto(this.tablero);
        Vehiculo spy = spy(moto);
        when(spy.makeRandom()).thenReturn(randomMock);

        ///se usa spy.method() para llamar métodos reales
        spy.asignarCeldaInicial(celdaMock);
        spy.aplicarModificador(controlPolicial);

        assertEquals(3, spy.movimientos());

    }

    @Test
    public void motoAplicaModificadorControlPoliciaCuandoSuperaProbabilidadNoEsPenalizadoCon3() {

        ControlPolicial controlPolicial = new ControlPolicial();

        Celda celdaMock = mock(Celda.class);
        when(celdaMock.buscarSiguiente(any(Direccion.class)))
                .thenReturn(new Celda(0, 0));

        Random randomMock = mock(Random.class);
        when(randomMock.nextFloat())
                .thenReturn(0.81f);

        Vehiculo moto = new Moto(this.tablero);
        Vehiculo spy = spy(moto);
        when(spy.makeRandom()).thenReturn(randomMock);

        ///se usa spy.method() para llamar métodos reales
        spy.asignarCeldaInicial(celdaMock);
        spy.aplicarModificador(controlPolicial);

        assertEquals(0, spy.movimientos());

    }

}