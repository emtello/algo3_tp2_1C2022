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

public class AutoTest extends VehiculoTest {

    @Test
    public void autoAplicaModificadorPozoYEsPenalizadoCon3Movimientos() {

        Celda celdaMock = mock(Celda.class);
        when(celdaMock.buscarSiguiente(any(Direccion.class)))
                .thenReturn(new Celda(0, 0));

        Vehiculo auto = new Auto(this.tablero);

        auto.asignarCeldaInicial(celdaMock);

        Pozo pozo = new Pozo();

        auto.aplicarModificador(pozo);

        assertEquals(3, auto.movimientos());
    }

    @Test
    public void autoAplicaModificadorCambioDeVehiculoYCambiaPorCamioneta() {
        CambioDeVehiculo cambioDeVehiculo = new CambioDeVehiculo();

        Celda celdaMock = mock(Celda.class);
        when(celdaMock.buscarSiguiente(any(Direccion.class)))
                .thenReturn(new Celda(0, 0));

        Vehiculo auto = new Auto(this.tablero);

        auto.asignarCeldaInicial(celdaMock);

        auto.aplicarModificador(cambioDeVehiculo);

        assertEquals(Camioneta4x4.class, this.tablero.obtenerVehiculo().getClass());
    }

    @Test
    public void autoAplicaModificadorPiqueteNoAtraviezaYNoEsPenalizado() {

        Piquete piquete = new Piquete();

        Celda celdaMock = mock(Celda.class);
        when(celdaMock.buscarSiguiente(any(Direccion.class)))
                .thenReturn(new Celda(0, 0));

        Vehiculo auto = new Auto(this.tablero);

        auto.asignarCeldaInicial(celdaMock);

        auto.aplicarModificador(piquete);

        assertEquals(0, auto.movimientos());

    }

    /*@Test
    public void autoAplicaModificadorControlPoliciaEsPenalizadoCon3() {

        ControlPolicial controlPolicial = new ControlPolicial();

        Celda celdaMock = mock(Celda.class);
        when(celdaMock.buscarSiguiente(any(Direccion.class)))
                .thenReturn(new Celda(0, 0));

        Vehiculo auto = new Auto(this.tablero);

        auto.asignarCeldaInicial(celdaMock);

        auto.aplicarModificador(controlPolicial);

        assertEquals(3, auto.movimientos());

    }*/

    @Test
    public void autoAplicaModificadorControlPoliciaCuandoNoSuperaProbabilidadEsPenalizadoCon3() {

        ControlPolicial controlPolicial = new ControlPolicial();

        Celda celdaMock = mock(Celda.class);
        when(celdaMock.buscarSiguiente(any(Direccion.class)))
                .thenReturn(new Celda(0, 0));

        Random randomMock = mock(Random.class);
        when(randomMock.nextFloat())
                .thenReturn(0.5f);

        Vehiculo auto = new Auto(this.tablero);
        Vehiculo spy = spy(auto);
        when(spy.makeRandom()).thenReturn(randomMock);

        ///se usa spy.method() para llamar métodos reales
        spy.asignarCeldaInicial(celdaMock);
        spy.aplicarModificador(controlPolicial);

        assertEquals(3, spy.movimientos());

    }

    @Test
    public void autoAplicaModificadorControlPoliciaCuandoSuperaProbabilidadNoEsPenalizadoCon3() {

        ControlPolicial controlPolicial = new ControlPolicial();

        Celda celdaMock = mock(Celda.class);
        when(celdaMock.buscarSiguiente(any(Direccion.class)))
                .thenReturn(new Celda(0, 0));

        Random randomMock = mock(Random.class);
        when(randomMock.nextFloat())
                .thenReturn(0.51f);

        Vehiculo auto = new Auto(this.tablero);
        Vehiculo spy = spy(auto);
        when(spy.makeRandom()).thenReturn(randomMock);

        ///se usa spy.method() para llamar métodos reales
        spy.asignarCeldaInicial(celdaMock);
        spy.aplicarModificador(controlPolicial);

        assertEquals(0, spy.movimientos());

    }

}