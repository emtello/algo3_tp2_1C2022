package edu.fiuba.algo3.modelo.registro;

public class Puntaje implements Comparable<Puntaje> {
    private String usuario;
    private long puntaje;

    public Puntaje(String usuario, long puntaje) {
        this.usuario = usuario;
        this.puntaje = puntaje;
    }

    public long getPuntaje() {
        return this.puntaje;
    }

    public void setPuntaje(long puntaje) {
        this.puntaje = puntaje;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public int compareTo(Puntaje otroPuntaje) {
        if (this.getPuntaje() > otroPuntaje.getPuntaje()) {
            return 1;
        }
        if (this.getPuntaje() < otroPuntaje.getPuntaje()) {
            return -1;
        }
        return 0;
        // return this.getPuntos().compareTo(otroPuntaje.getPuntos());  
    }
}
