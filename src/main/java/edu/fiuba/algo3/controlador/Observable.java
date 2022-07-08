package edu.fiuba.algo3.controlador;

public interface Observable {
    
    public void agregar(Observer observer);
    public void eliminar(Observer observer);
    public void notificar();

}
