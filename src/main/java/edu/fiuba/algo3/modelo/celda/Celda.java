package edu.fiuba.algo3.modelo.celda;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.calle.Calle;
import edu.fiuba.algo3.modelo.direccion.Direccion;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificador.Modificador;

public class Celda {
    
    private Integer f;
    private Integer c;
    private ArrayList<Calle> calles;

    public Celda(Integer f, Integer c) {
        this.f = f;
        this.c = c;
        this.calles = new ArrayList<Calle>();
    }

    public Integer fila() {
        return f;
    }

    public Integer columna() {
        return c;
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

        throw new Error("No se encontro la calle");
    }

    public Celda mover(Jugador jug, Direccion dir) {
        ArrayList<Celda> esquinas = this.obtenerEsquinas();
        
        Celda sigCelda = dir.mover(f, c, esquinas);
        Calle sigCalle = this.obtenerCalleDeEsquina(sigCelda);
        

        // revisar

        sigCalle.cruzarCon(jug);
        // return sigCalle.cruzarCon(jug, sigCelda);


        return sigCelda;
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

}
