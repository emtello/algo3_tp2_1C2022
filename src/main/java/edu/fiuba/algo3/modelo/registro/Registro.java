package edu.fiuba.algo3.modelo.registro;

import java.util.ArrayList;
import java.util.Collections;


public class Registro {
    private ArrayList<Puntaje> puntajes;

    public Registro () {
        this.puntajes = new ArrayList<Puntaje>();
    }

    public void cargarPuntaje(Puntaje puntaje) {
        this.puntajes.add(puntaje);
    }

    public ArrayList<Puntaje> obtenerPuntajes() {
        this.ordenarMayorAMenor();
        return this.puntajes;
    }

    public void ordenarMayorAMenor() {
        // Es de menor movimientos a mayor movimientos el puntaje?
        Collections.sort(this.puntajes);
        
        // descomentar si se quiere ordenar de mayor a menor
        // Collections.reverse(this.puntajes);  
    }

    public Puntaje obtenerPuntaje(int index) {
        return this.puntajes.get(index);
    }
}
