package edu.fiuba.algo3.modelo.modificador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.direccion.Direccion;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.Camioneta4x4;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class NuloTest extends ModificadorTest {

    @Test
    public void modificadorNuloSeCruzaConvehiculoConMotoYSumaUnMovimiento() {
        Nulo nulo = new Nulo();
        
        Celda celdaMock = mock(Celda.class);
        when(celdaMock.buscarSiguiente(any(Direccion.class)))
        .thenReturn(new Celda(0, 0));
        
        Vehiculo moto = new Moto(this.tablero);
    
        moto.asignarCeldaInicial(celdaMock);

        nulo.cruzarCon(moto);

        assertEquals(0, moto.movimientos());
    }

    @Test
    public void modificadorNuloSeCruzaConvehiculoConAutoYSumaUnMovimiento() {
        Nulo nulo = new Nulo();
        
        Celda celdaMock = mock(Celda.class);
        when(celdaMock.buscarSiguiente(any(Direccion.class)))
        .thenReturn(new Celda(0, 0));

        Vehiculo auto = new Auto(this.tablero);
        
        auto.asignarCeldaInicial(celdaMock);

        nulo.cruzarCon(auto);

        assertEquals(0, auto.movimientos());
    }

    @Test
    public void modificadorNuloSeCruzaConvehiculoConCamionetaYSumaUnMovimiento() {
        Nulo nulo = new Nulo();
        
        Celda celdaMock = mock(Celda.class);
        when(celdaMock.buscarSiguiente(any(Direccion.class)))
        .thenReturn(new Celda(0, 0));
        
        Vehiculo camioneta = new Camioneta4x4(this.tablero);
        
        camioneta.asignarCeldaInicial(celdaMock);

        nulo.cruzarCon(camioneta);

        assertEquals(0, camioneta.movimientos());
    }

}