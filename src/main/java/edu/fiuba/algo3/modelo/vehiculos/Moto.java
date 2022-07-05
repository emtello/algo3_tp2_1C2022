package edu.fiuba.algo3.modelo.vehiculos;

import edu.fiuba.algo3.modelo.modificador.*;
import java.util.Observable;

import edu.fiuba.algo3.modelo.tablero.Tablero;

public class Moto extends Vehiculo {

    private long penalizacionPorPozo = 3;
    private long penalizacionPorPiquete = 2;
    private long penalizacionPorControlPolicial = 3;


    
    public Moto(Tablero tablero) {
        super(tablero);
        this.nombre = "moto";
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
        this.sumarMovimientos(this.penalizacionPorPiquete);
        this.actualizarASiguienteCelda();

    }

    @Override
    public void aplicarModificador(ControlPolicial controlPolicial) {
        this.sumarMovimientos(this.penalizacionPorControlPolicial);
        this.actualizarASiguienteCelda();

    }

    @Override
    public void aplicarModificador(CambioDeVehiculo cambioDeVehiculo) {
        Vehiculo reemplazo = new Auto(this.tablero);

        reemplazo.asignarCeldaInicial(this.celdaInicial);
        reemplazo.sumarMovimientos(this.movimientos);

        this.tablero.reemplazarVehiculo(reemplazo);

        this.actualizarASiguienteCelda();

    }

    public static long probabilidadControl() {
        return 8;
    }

}