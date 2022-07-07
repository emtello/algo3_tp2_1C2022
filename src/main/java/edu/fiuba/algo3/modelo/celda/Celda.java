package edu.fiuba.algo3.modelo.celda;

import java.util.ArrayList;
import java.util.Observable;

import edu.fiuba.algo3.modelo.calle.Calle;
import edu.fiuba.algo3.modelo.direccion.Direccion;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class Celda extends Observable {
    
    private long f;
    private long c;
    private ArrayList<Calle> calles;

    public Celda(long f, long c) {
        this.f = f;
        this.c = c;
        this.calles = new ArrayList<Calle>();
    }

    public long fila() {
        return f;
    }

    public long columna() {
        return c;
    }

    public ArrayList<Calle> calles() {
        return calles;
    }
    
    public Celda buscarSiguiente(Direccion direccion) {
        ArrayList<Celda> esquinas = this.obtenerEsquinas();

        return direccion.mover(this.f, this.c, esquinas);
    }

    public void agregarCalle(Calle calle) {
        if (!calles.contains(calle)) {
            this.calles.add(calle);
        }

        if (this.calles.size() > 4) throw new Error();
    }

    private ArrayList<Celda> obtenerEsquinas() {
        ArrayList<Celda> esquinas = new ArrayList<Celda>();
        
        for (Calle calle : this.calles) {
            esquinas.add(calle.siguienteEsquina(this));
        }

        return esquinas;
    }

    private Calle obtenerCalleDeEsquina(Celda fin) {
        for (Calle calle : this.calles) {
            if (calle.contiene(fin)) return calle;
        }

        // Ver si se puede capturar de otra forma, que salga como texto ponele?
        throw new Error("No se encontro la calle");
    }

    public void mover(Vehiculo vehiculo, Direccion dir) {
        Celda sigCelda = this.buscarSiguiente(dir);
        Calle sigCalle = this.obtenerCalleDeEsquina(sigCelda);
    
        // sigCalle.notifyObservers();
        sigCalle.cruzarCon(vehiculo);
    }

    public void borrarModificadores() {
        for (Calle calle : this.calles) {
            calle.borrarModificadores();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Celda)) {
            return false;
        }

        Celda unaCelda = (Celda) obj;
        
        if (this.fila() != unaCelda.fila()) return false;
        if (this.columna() != unaCelda.columna()) return false;

        return true;
    }

    @Override
    public String toString() {
        return "(" + this.fila() + ", " + this.columna() +")";
    }

    public Boolean esAdyacente(Celda celda) {
        try {
            this.obtenerCalleDeEsquina(celda);
            return true;
        } catch (Error e) {
            return false;
        }
    }

}
