package edu.fiuba.algo3;

public class Puntos {
    private String usuario;
    private long puntaje;

    public Puntos(String usuario, long puntaje) {
        this.usuario = usuario;
        this.puntaje = puntaje;
    }

    public long getPuntaje() {
        return puntaje;
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
}
