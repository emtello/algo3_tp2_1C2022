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

}