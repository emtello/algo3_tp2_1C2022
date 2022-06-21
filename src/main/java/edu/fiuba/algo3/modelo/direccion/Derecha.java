package edu.fiuba.algo3.modelo.direccion;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.celda.Celda;

public class Derecha implements Direccion {
    
    @Override
    public Celda mover(long f, long c, ArrayList<Celda> esquinas) {
        for (Celda e : esquinas) {
            if (e.fila() == f && e.columna() == c + 1) return e;
        }
        
        return null;
    }

}
