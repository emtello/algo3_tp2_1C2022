package edu.fiuba.algo3.modelo.modificador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import edu.fiuba.algo3.modelo.vehiculos.*;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.direccion.Direccion;

public class PozoTest extends ModificadorTest {

    @Test
    public void modificadorPozoSeCruzaConvehiculoConMotoYEsPenalizadoCon3() {
        Pozo pozo = new Pozo();
        
        Celda celdaMock = mock(Celda.class);
        when(celdaMock.buscarSiguiente(any(Direccion.class)))
        .thenReturn(new Celda(0, 0));

        Vehiculo moto = new Moto(this.tablero);
        
        moto.asignarCeldaInicial(celdaMock);

        pozo.cruzarCon(moto);

        assertEquals(3, moto.movimientos());
    }

    @Test
    public void modificadorPozoSeCruzaConvehiculoReliantRobinYEsPenalizadoCon3() {
        Pozo pozo = new Pozo();

        Celda celdaMock = mock(Celda.class);
        when(celdaMock.buscarSiguiente(any(Direccion.class)))
                .thenReturn(new Celda(0, 0));

        Vehiculo reliant = new ReliantRobin(this.tablero);

        reliant.asignarCeldaInicial(celdaMock);

        pozo.cruzarCon(reliant);

        assertEquals(3, reliant.movimientos());
    }

    @Test
    public void modificadorPozoSeCruzaConvehiculoConAutoYEsPenalizadoCon3() {
        Pozo pozo = new Pozo();
        
        Celda celdaMock = mock(Celda.class);
        when(celdaMock.buscarSiguiente(any(Direccion.class)))
        .thenReturn(new Celda(0, 0));

        Vehiculo auto = new Auto(this.tablero);
        
        auto.asignarCeldaInicial(celdaMock);

        pozo.cruzarCon(auto);

        assertEquals(3, auto.movimientos());
    }

    @Test
    public void modificadorPozoSeCruzaConvehiculoConCamionetaYNoEsPenalizadoPorPrimeraVez() {
        Pozo pozo = new Pozo();

        Celda celdaMock = mock(Celda.class);
        when(celdaMock.buscarSiguiente(any(Direccion.class)))
        .thenReturn(new Celda(0, 0));

        Vehiculo camioneta = new Camioneta4x4(this.tablero);
    
        camioneta.asignarCeldaInicial(celdaMock);

        pozo.cruzarCon(camioneta);

        assertEquals(0, camioneta.movimientos());
    }

    @Test
    public void modificadorPozoSeCruzaConvehiculoConCamionetaYEsPenalizadoCon2() {
        Pozo pozo = new Pozo();

        Celda celdaMock = mock(Celda.class);
                
        when(celdaMock.buscarSiguiente(any(Direccion.class)))
        .thenReturn(new Celda(0, 0));

        Vehiculo camioneta = new Camioneta4x4(this.tablero);
        
        camioneta.asignarCeldaInicial(celdaMock);

        for(int i= 0; i < 4; i++) {
            assertEquals(0, camioneta.movimientos());
            camioneta.asignarCeldaInicial(celdaMock);
            pozo.cruzarCon(camioneta);
        }

        assertEquals(2, camioneta.movimientos());
    }

}