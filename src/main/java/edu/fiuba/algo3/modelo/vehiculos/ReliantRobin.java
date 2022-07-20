package edu.fiuba.algo3.modelo.vehiculos;

import edu.fiuba.algo3.modelo.modificador.*;
import edu.fiuba.algo3.modelo.tablero.Tablero;

public class ReliantRobin extends Vehiculo {

    private long penalizacionPorPozo = 3;

    private Auto auto = new Auto(this.tablero);

    public ReliantRobin(Tablero tablero) {
        super(tablero);
        this.nombre = "reliantrobin";
    }

    @Override
    public void aplicarModificador(Modificador modificador) {

    }

    @Override
    public void aplicarModificador(Pozo pozo) {
        this.sumarMovimientos(this.penalizacionPorPozo);
        this.actualizarASiguienteCelda();
    }

    @Override
    public void aplicarModificador(Piquete piquete) {

    }

    @Override
    public void aplicarModificador(ControlPolicial controlPolicial) {

    }

    @Override
    public void aplicarModificador(CambioDeVehiculo cambioDeVehiculo) {

    }

    @Override
    public void aplicarModificador(Piquetazo piquetazo) {

    }
}
