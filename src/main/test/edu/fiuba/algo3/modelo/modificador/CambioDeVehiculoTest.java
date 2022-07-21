package edu.fiuba.algo3.modelo.modificador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import edu.fiuba.algo3.modelo.vehiculos.*;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.direccion.Direccion;

public class CambioDeVehiculoTest extends ModificadorTest {

    @Test
    public void modificadorCambioDeVehiculoSeCruzaConVehiculoMotoYCambiaPorAuto() {
        CambioDeVehiculo cambioDeVehiculo = new CambioDeVehiculo();
        
        Celda celdaMock = mock(Celda.class);
        when(celdaMock.buscarSiguiente(any(Direccion.class)))
        .thenReturn(new Celda(0, 0));

        Vehiculo moto = new Moto(this.tablero);
    
        moto.asignarCeldaInicial(celdaMock);

        cambioDeVehiculo.cruzarCon(moto);

        assertEquals(ReliantRobin.class, this.tablero.obtenerVehiculo().getClass());
    }

    @Test
    public void modificadorCambioDeVehiculoSeCruzaConVehiculoAutoYCambiaPor4X4() {
        CambioDeVehiculo cambioDeVehiculo = new CambioDeVehiculo();

        Celda celdaMock = mock(Celda.class);
        when(celdaMock.buscarSiguiente(any(Direccion.class)))
        .thenReturn(new Celda(0, 0));

        Vehiculo auto = new Auto(this.tablero);
        
        auto.asignarCeldaInicial(celdaMock);

        cambioDeVehiculo.cruzarCon(auto);

        assertEquals(Camioneta4x4.class, this.tablero.obtenerVehiculo().getClass());
    }

    @Test
    public void modificadorCambioDeVehiculoSeCruzaConVehiculoCamionetaYCambiaPorMoto() {
        CambioDeVehiculo cambioDeVehiculo = new CambioDeVehiculo();
        
        Celda celdaMock = mock(Celda.class);
        when(celdaMock.buscarSiguiente(any(Direccion.class)))
        .thenReturn(new Celda(0, 0));
        
        Vehiculo camioneta = new Camioneta4x4(this.tablero);
        
        camioneta.asignarCeldaInicial(celdaMock);

        cambioDeVehiculo.cruzarCon(camioneta);

        assertEquals(Moto.class, this.tablero.obtenerVehiculo().getClass());
    }
    
}