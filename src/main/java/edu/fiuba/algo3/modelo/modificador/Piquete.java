package edu.fiuba.algo3.modelo.modificador;

import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class Piquete implements Modificador {
    
    private final String nombre = "piquete";

    @Override
    public void cruzarCon(Vehiculo vehiculo) {
        vehiculo.aplicarModificador(this);
    }

    @Override
    public String getNombre() {
        return nombre;
    }

}
