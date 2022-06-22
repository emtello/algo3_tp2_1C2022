package edu.fiuba.algo3.integracion;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.calle.Calle;
import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.direccion.Derecha;
import edu.fiuba.algo3.modelo.direccion.Direccion;
import edu.fiuba.algo3.modelo.modificador.ControlPolicial;
import edu.fiuba.algo3.modelo.modificador.Desfavorable;
import edu.fiuba.algo3.modelo.modificador.Favorable;
import edu.fiuba.algo3.modelo.modificador.Modificador;
import edu.fiuba.algo3.modelo.modificador.Nulo;
import edu.fiuba.algo3.modelo.modificador.Piquete;
import edu.fiuba.algo3.modelo.modificador.Pozo;
import edu.fiuba.algo3.modelo.tablero.Tablero;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class TercerEntregaTest {
    
    Tablero tablero = new Tablero(10, 10);
    Celda celdaInicial = new Celda(0, 0);
    Celda celdaFinal = new Celda(0, 1);
    Direccion direccion = new Derecha();

    ArrayList<Modificador> modificadores = new ArrayList<Modificador>();

    public void generarTablero(Celda celdaInicial) {
        this.tablero.iniciarEn(celdaInicial);
        celdaInicial = this.tablero.obtenerPosicion();

        // Recorrer grafo por bfs

        ArrayList<Celda> visitados = new ArrayList<Celda>();
        ArrayList<Celda> cola = new ArrayList<Celda>();
        ArrayList<Calle> calles = celdaInicial.calles();
        
        visitados.add(celdaInicial);
        cola.add(celdaInicial);
    
        while (!cola.isEmpty()) {
            Celda actual = cola.remove(0);
            calles = actual.calles();
            
            for (Calle calle : calles) {
                Celda esquina = calle.siguienteEsquina(actual);

                if (!visitados.contains(esquina)) {
                    int random = (int) (Math.random() * modificadores.size());
                    
                    calle.agregarModificador(modificadores.get(random));
                    visitados.add(esquina);
                    cola.add(esquina);

                }
            }
        }
    }

    public void iniciarConfig(Vehiculo vehiculo) {
        modificadores.add(new Piquete());
        modificadores.add(new Pozo());
        modificadores.add(new ControlPolicial());
        modificadores.add(new Favorable());
        modificadores.add(new Desfavorable());
        modificadores.add(new Nulo());

        this.tablero.agregarvehiculo(vehiculo);
        this.generarTablero(this.celdaInicial);
    }
    
    @Test
    public void unVehiculoAvanzaPorLaCiudadYEncuentraLlegadaElJuegoTermina() {
        Vehiculo vehiculo = new Moto(this.tablero);

        this.iniciarConfig(vehiculo);
        this.tablero.asignarLlegada(celdaFinal);


        assertTrue(this.tablero.mover(this.direccion));
    }

    @Test
    public void unaMotoSeMuevePorUnCaminoAleatorioDelTableroYNoArrojaErrores() {
        Vehiculo vehiculo = new Moto(this.tablero);
        this.iniciarConfig(vehiculo);

        Direccionador direccionador = new Direccionador();
        
        Direccion direccion;

        for (int i = 0; i < 100; i++) {
            Celda celda = this.tablero.obtenerPosicion();
            direccion = direccionador.siguienteDireccion(celda);
            assertFalse(this.tablero.mover(direccion));
        }
    }
    
}
