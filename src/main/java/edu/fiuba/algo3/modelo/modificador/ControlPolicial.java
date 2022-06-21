package edu.fiuba.algo3.modelo.modificador;

import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class ControlPolicial implements Modificador {

    @Override
    public void cruzarCon(Vehiculo vehiculo) {
        vehiculo.controlPolicial();
    }

}
