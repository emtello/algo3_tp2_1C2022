package edu.fiuba.algo3.modelo.vehiculo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.tablero.Tablero;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class VehiculoTest {
    
  Tablero tablero = new Tablero(10, 10);
    Vehiculo vehiculo = new Moto(this.tablero);

    @Test
    public void test01VehiculoEstaEnUnaCeldaYDevuelveTrue() {
        Celda celda = new Celda(1, 1);
        this.vehiculo.asignarCeldaInicial(celda);

        assertTrue(this.vehiculo.estaEn(celda));

    }

    @Test
    public void test02VehiculoNoEstaEnUnaCeldaYDevuelveFalse() {
        Celda celda = new Celda(1, 1);
        this.vehiculo.asignarCeldaInicial(celda);

        assertTrue(!this.vehiculo.estaEn(new Celda(1, 2)));

    }

}
