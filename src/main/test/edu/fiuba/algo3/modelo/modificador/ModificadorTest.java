package edu.fiuba.algo3.modelo.modificador;

import edu.fiuba.algo3.modelo.calle.Calle;
import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.direccion.Derecha;
import edu.fiuba.algo3.modelo.direccion.Direccion;
import edu.fiuba.algo3.modelo.tablero.Tablero;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class ModificadorTest {
    
    Tablero tablero = new Tablero(10, 10);
    Vehiculo moto = new Moto(this.tablero);
    Celda celdaInicial = new Celda(0, 0);
    Celda celdaFinal = new Celda(0, 1);
    Direccion direccion = new Derecha();

    public void iniciarConfig(Vehiculo vehiculo, Modificador modificador) {    
        this.tablero.agregarvehiculo(vehiculo);
        this.tablero.iniciarEn(celdaInicial);
        
        Calle calle = new Calle(this.celdaInicial, this.celdaFinal, modificador);
        
        this.celdaInicial.agregarCalle(calle);
        this.celdaFinal.agregarCalle(calle);
    }

}
