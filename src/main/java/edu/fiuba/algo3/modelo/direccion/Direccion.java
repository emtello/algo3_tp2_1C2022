package edu.fiuba.algo3.modelo.direccion;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.celda.Celda;

public interface Direccion {

    public Celda mover(long f, long c, ArrayList<Celda> esquinas);

}
