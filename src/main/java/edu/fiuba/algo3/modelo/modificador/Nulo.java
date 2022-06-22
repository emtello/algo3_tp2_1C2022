package edu.fiuba.algo3.modelo.modificador;

import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class Nulo implements Modificador {

    @Override
    public void cruzarCon(Vehiculo vehiculo) {
        vehiculo.actualizarASiguienteCelda();
    }

    @Override
    public String simbolo() {
        return "NU";
    }
    
}
