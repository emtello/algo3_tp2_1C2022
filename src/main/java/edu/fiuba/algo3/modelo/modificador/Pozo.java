package edu.fiuba.algo3.modelo.modificador;

import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class Pozo implements Modificador {

    @Override
    public void cruzarCon(Vehiculo vehiculo) {
        vehiculo.pozo();
    }

    @Override
    public String simbolo() {
        return "PO";
    }

}