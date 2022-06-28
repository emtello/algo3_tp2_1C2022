package edu.fiuba.algo3.modelo.tablero;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.direccion.Arriba;
import edu.fiuba.algo3.modelo.excepcion.CeldaFueraDeRango;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;


public class TableroTest {

    @Test
    public void iniciarElvehiculoEnElOrigen() {
        Tablero tablero = new Tablero(5, 5);
        Vehiculo moto = new Moto(tablero);

        tablero.usarVehiculo(moto);
        
        Celda celdaInicial = new Celda(1, 0);
        
        tablero.iniciarEn(celdaInicial);

        assertEquals(celdaInicial, tablero.obtenerPosicion());
    }
    
    @Test
    public void noAsociarUnvehiculoYMoverDevuelveError() {
        Tablero tablero = new Tablero(5, 5);
        Celda celda = new Celda(1,0);

        assertThrows(RuntimeException.class, () -> tablero.iniciarEn(celda));
    }

    @Test
    public void moverElvehiculoFueraDeLimiteDevuelveError() {
        Tablero tablero = new Tablero(5, 5);
        Vehiculo moto = new Moto(tablero);

        tablero.usarVehiculo(moto);
        tablero.iniciarEn(new Celda(1, 0));

        assertThrows(CeldaFueraDeRango.class, () -> tablero.mover(new Arriba()));
    }

}