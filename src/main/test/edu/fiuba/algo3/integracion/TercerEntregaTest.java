package edu.fiuba.algo3.integracion;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.direccion.Derecha;
import edu.fiuba.algo3.modelo.direccion.Direccion;
import edu.fiuba.algo3.modelo.modificador.Modificador;
import edu.fiuba.algo3.modelo.tablero.Tablero;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class TercerEntregaTest {
    
  Tablero tablero = new Tablero(10, 10);
    Celda celdaInicial = new Celda(1, 0);
    Celda celdaFinal = new Celda(1, 1);
    Direccion direccion = new Derecha();

    ArrayList<Modificador> modificadores = new ArrayList<Modificador>();


    public void iniciarConfig(Vehiculo vehiculo) {
        this.tablero.usarVehiculo(vehiculo);
        this.tablero.generarAleatorio();
        this.tablero.iniciarEn(this.celdaInicial);
    }
    
    @Test
    public void unVehiculoAvanzaPorLaCiudadYEncuentraLlegadaElJuegoTermina() {
        Vehiculo vehiculo = new Moto(this.tablero);

        this.iniciarConfig(vehiculo);
        this.tablero.finalizarEn(celdaFinal);

        assertTrue(this.tablero.mover(this.direccion));
    }

    @Test
    public void unaMotoSeMuevePorUnCaminoAleatorioDelTableroYNoArrojaErrores() {
        Vehiculo vehiculo = new Moto(this.tablero);
        this.iniciarConfig(vehiculo);

        Direccionador direccionador = new Direccionador();
        
        Direccion direccion;

        for (int i = 0; i < 500; i++) {
            Celda celda = this.tablero.obtenerPosicion();

            direccion = direccionador.siguienteDireccion(celda);
            assertFalse(this.tablero.mover(direccion));
        }
    }
    
}
