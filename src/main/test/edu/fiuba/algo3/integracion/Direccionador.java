package edu.fiuba.algo3.integracion;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.direccion.Abajo;
import edu.fiuba.algo3.modelo.direccion.Arriba;
import edu.fiuba.algo3.modelo.direccion.Derecha;
import edu.fiuba.algo3.modelo.direccion.Direccion;
import edu.fiuba.algo3.modelo.direccion.Izquierda;
import edu.fiuba.algo3.modelo.excepcion.CeldaFueraDeRango;

public class Direccionador {

    private ArrayList<Direccion> direcciones;

    public Direccionador() {
        this.direcciones = new ArrayList<Direccion>();
        this.direcciones.add(new Arriba());
        this.direcciones.add(new Abajo());
        this.direcciones.add(new Izquierda());
        this.direcciones.add(new Derecha());
    }

    public Direccion siguienteDireccion(Celda celda) {
        ArrayList<Direccion> direcValidas = new ArrayList<Direccion>();
        
        for (Direccion direccion : this.direcciones) {
            try {
                celda.buscarSiguiente(direccion);
                direcValidas.add(direccion);
            } catch (CeldaFueraDeRango e) {
                // No hacemos nada
            }
        }

        return direcValidas.get((int) (Math.random() * direcValidas.size()));
    }

}
