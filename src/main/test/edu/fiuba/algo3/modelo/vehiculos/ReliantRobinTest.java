package edu.fiuba.algo3.modelo.vehiculos;

import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.direccion.Direccion;
import edu.fiuba.algo3.modelo.modificador.CambioDeVehiculo;
import edu.fiuba.algo3.modelo.modificador.Pozo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ReliantRobinTest extends VehiculoTest{

    @Test
    public void reliantRobinAplicaModificadorPozoYEsPenalizadoCon3Movimientos() {

        Celda celdaMock = mock(Celda.class);
        when(celdaMock.buscarSiguiente(any(Direccion.class)))
                .thenReturn(new Celda(0, 0));

        Vehiculo reliant = new ReliantRobin(this.tablero);

        reliant.asignarCeldaInicial(celdaMock);

        Pozo pozo = new Pozo();

        reliant.aplicarModificador(pozo);

        assertEquals(3, reliant.movimientos());
    }

    @Test
    public void reliantRobinAplicaModificadorCambioDeVehiculoYCambiaPorAuto() {
        CambioDeVehiculo cambioDeVehiculo = new CambioDeVehiculo();

        Celda celdaMock = mock(Celda.class);
        when(celdaMock.buscarSiguiente(any(Direccion.class)))
                .thenReturn(new Celda(0, 0));

        Vehiculo reliant = new ReliantRobin(this.tablero);

        reliant.asignarCeldaInicial(celdaMock);

        reliant.aplicarModificador(cambioDeVehiculo);

        assertEquals(Auto.class, this.tablero.obtenerVehiculo().getClass());
    }
}
