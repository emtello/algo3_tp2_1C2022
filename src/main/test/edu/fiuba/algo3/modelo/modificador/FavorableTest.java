package edu.fiuba.algo3.modelo.modificador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.direccion.Direccion;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class FavorableTest extends ModificadorTest {

    @Test
    public void  modificadorFavorableSeCruzaConVehiculoResta20PorcientoDeMovimientos() {
        Favorable favorable = new Favorable();
        
        Celda celdaMock = mock(Celda.class);
        when(celdaMock.buscarSiguiente(any(Direccion.class)))
        .thenReturn(new Celda(0, 0));

        Vehiculo moto = new Moto(this.tablero);
        
        moto.asignarCeldaInicial(celdaMock);
        moto.sumarMovimientos(10);
        
        favorable.cruzarCon(moto);
        
        assertEquals(Math.round((10 * 0.8)), moto.movimientos());
    }

}