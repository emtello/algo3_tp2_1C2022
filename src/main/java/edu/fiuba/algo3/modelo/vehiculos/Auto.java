package edu.fiuba.algo3.modelo.vehiculos;

import edu.fiuba.algo3.modelo.modificador.*;
import java.util.Observable;

import edu.fiuba.algo3.modelo.tablero.Tablero;

public class Auto extends Vehiculo {

    private long penalizacionPorPozo = 3;
    private long penalizacionPorControlPolicial = 3;
    
    public Auto(Tablero tablero) {
        super(tablero);
        this.nombre = "auto";
    }

    @Override
    public void aplicarModificador(Modificador modificador) {
        //
    }

    @Override
    public void aplicarModificador(Pozo pozo) {
        this.sumarMovimientos(this.penalizacionPorPozo);
        this.actualizarASiguienteCelda();
    }

    @Override
    public void aplicarModificador(Piquete piquete) {
        // Nada
    }

    @Override
    public void aplicarModificador(ControlPolicial controlPolicial) {
        this.sumarMovimientos(this.penalizacionPorControlPolicial);
        this.actualizarASiguienteCelda();
    }

    @Override
    public void aplicarModificador(CambioDeVehiculo cambioDeVehiculo) {
        Vehiculo reemplazo = new Camioneta4x4(this.tablero);

        reemplazo.asignarCeldaInicial(this.celdaInicial);
        reemplazo.sumarMovimientos(this.movimientos);

        this.tablero.reemplazarVehiculo(reemplazo);

        this.actualizarASiguienteCelda();
    }

    public static long probabilidadControl() {
        return 5;
    }

}
