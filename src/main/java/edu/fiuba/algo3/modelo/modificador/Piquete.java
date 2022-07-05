package edu.fiuba.algo3.modelo.modificador;

import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class Piquete implements Modificador {
    
    private final String nombre = "cambio-de-vehiculo";

    @Override
    public void cruzarCon(Vehiculo vehiculo) {
        vehiculo.piquete();
    }

    @Override
    public String getNombre() {
        return nombre;
    }

}
