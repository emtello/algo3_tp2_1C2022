package edu.fiuba.algo3.modelo.modificador;

import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class Nulo implements Modificador {

    private final String nombre = "nulo";

    @Override
    public void cruzarCon(Vehiculo vehiculo) {
        vehiculo.actualizarASiguienteCelda();
    }

    @Override
    public String getNombre() {
        return nombre;
    }

}
