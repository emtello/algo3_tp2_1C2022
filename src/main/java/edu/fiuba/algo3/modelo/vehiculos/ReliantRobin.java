package edu.fiuba.algo3.modelo.vehiculos;

import edu.fiuba.algo3.modelo.modificador.*;
import edu.fiuba.algo3.modelo.tablero.Tablero;

import java.util.Random;

public class ReliantRobin extends Vehiculo {

    private long penalizacionPorPozo = 3;

    private long penalizacionPorPiquetazo = 2;

    private Vehiculo vehiculoActual;

    private Auto auto = new Auto(this.tablero);

    private Moto moto = new Moto(this.tablero);

    private float probaComportamiento = 0.6f;

    public ReliantRobin(Tablero tablero) {
        super(tablero);
        this.nombre = "reliantrobin";
        this.vehiculoActual = auto;
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
        this.setVehiculoActual();

        this.vehiculoActual.setDireccionActual(this.direccionActual);
        this.vehiculoActual.asignarCeldaInicial(this.celdaInicial);
        vehiculoActual.aplicarModificador(piquete);
        this.setMovimientos(this.movimientos += vehiculoActual.movimientos());

        if(this.celdaInicial != vehiculoActual.getPosicion()) {
            this.actualizarASiguienteCelda();
            vehiculoActual.setMovimientos(0);
        }
    }

    @Override
    public void aplicarModificador(ControlPolicial controlPolicial) {
        this.setVehiculoActual();

        this.vehiculoActual.setDireccionActual(this.direccionActual);
        this.vehiculoActual.asignarCeldaInicial(this.celdaInicial);
        vehiculoActual.aplicarModificador(controlPolicial);
        this.setMovimientos(this.movimientos += vehiculoActual.movimientos());

        this.actualizarASiguienteCelda();
        vehiculoActual.setMovimientos(0);
    }

    @Override
    public void aplicarModificador(CambioDeVehiculo cambioDeVehiculo) {
        Vehiculo reemplazo = new Auto(this.tablero);

        this.tablero.reemplazarVehiculo(reemplazo);

        reemplazo.asignarCeldaInicial(this.celdaInicial);
        reemplazo.setDireccionActual(this.direccionActual);
        reemplazo.setMovimientos(this.movimientos);
        reemplazo.actualizarASiguienteCelda();
    }

    @Override
    public void aplicarModificador(Piquetazo piquetazo) {
        this.sumarMovimientos(this.penalizacionPorPiquetazo);
    }

    public void setVehiculoActual() {
        Random rand = makeRandom();
        float f = rand.nextFloat();
        if(f <= probaComportamiento) {
            this.vehiculoActual = auto;
        }
        else {
            this.vehiculoActual = moto;
        }
    }

}
