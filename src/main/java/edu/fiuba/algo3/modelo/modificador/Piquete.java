package edu.fiuba.algo3.modelo.modificador;

import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class Piquete implements Modificador {
    
    @Override
    public void cruzarCon(Vehiculo vehiculo) {
        vehiculo.aplicarModificador(this);
    }

    @Override
    public String simbolo() {
        return "PI";
    }
    
}
