package edu.fiuba.algo3.modelo.vehiculos;

import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.direccion.Direccion;
import edu.fiuba.algo3.modelo.modificador.CambioDeVehiculo;
import edu.fiuba.algo3.modelo.modificador.Pozo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class MotoTest extends VehiculoTest {

    @Test
    public void motoAplicaModificadorPozoYEsPenalizadoCon3Movimientos() {
        
        Celda celdaMock = mock(Celda.class);
        when(celdaMock.buscarSiguiente(any(Direccion.class)))
                .thenReturn(new Celda(0, 0));

        Vehiculo moto = new Moto(this.tablero);

        moto.asignarCeldaInicial(celdaMock);

        Pozo pozo = new Pozo();

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

        assertEquals(Auto.class, this.tablero.getVehiculo().getClass());

    }

}