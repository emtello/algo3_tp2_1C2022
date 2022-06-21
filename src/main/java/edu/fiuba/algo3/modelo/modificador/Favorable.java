package edu.fiuba.algo3.modelo.modificador;

import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class Favorable implements Modificador, Sorpresa {

    @Override
    public void cruzarCon(Vehiculo vehiculo) {
        vehiculo.sorpresa(this);
    }

    @Override
    public long aplicarSorpresa(long movimientos) {
        return (Math.toIntExact(Math.round(
            movimientos * 0.8
        )));
    }

}
