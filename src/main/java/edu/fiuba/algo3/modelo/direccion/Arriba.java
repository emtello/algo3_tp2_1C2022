package edu.fiuba.algo3.modelo.direccion;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.celda.Celda;

public class Arriba implements Direccion {
    
    @Override
    public Celda mover(long f, long c, ArrayList<Celda> esquinas) {
        for (Celda e : esquinas) {
            if (e.fila() == f - 1 && e.columna() == c) return e;
        }

        return null;
    }
    
}
