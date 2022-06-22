package edu.fiuba.algo3.modelo.registro;

public class Puntaje implements Comparable<Puntaje> {
    private String usuario;
    private long puntaje;

    public Puntaje(String usuario, long puntos) {
        this.usuario = usuario;
        this.puntaje = puntos;
    }

    public long getPuntos() {
        return this.puntaje;
    }

    @Override
    public int compareTo(Puntaje otroPuntaje) {
        if (this.getPuntos() > otroPuntaje.getPuntos()) {
            return 1;
        }
        if (this.getPuntos() < otroPuntaje.getPuntos()) {
            return -1;
        }
        return 0;
        // return this.getPuntos().compareTo(otroPuntaje.getPuntos());  
    }
}
