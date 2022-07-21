package edu.fiuba.algo3.modelo.vehiculos;

import edu.fiuba.algo3.modelo.modificador.*;
import edu.fiuba.algo3.modelo.tablero.Tablero;

import java.util.Random;

public class Moto extends Vehiculo {

    private long penalizacionPorPozo = 3;
    private long penalizacionPorPiquete = 2;
    private long penalizacionPorControlPolicial = 3;
    private long penalizacionPorPiquetazo = 2;

    private float probaMoto = 0.8f;

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

        Random rand = makeRandom();
        float f = rand.nextFloat();

        if(f <= probaMoto) {
            this.sumarMovimientos(this.penalizacionPorControlPolicial);
        }
        this.actualizarASiguienteCelda();

    }

    @Override
    public void aplicarModificador(CambioDeVehiculo cambioDeVehiculo) {
        Vehiculo reemplazo = new ReliantRobin(this.tablero);

        this.tablero.reemplazarVehiculo(reemplazo);
        
        reemplazo.asignarCeldaInicial(this.celdaInicial);
        reemplazo.setDireccionActual(this.direccionActual);
        reemplazo.setMovimientos(this.movimientos);
        reemplazo.actualizarASiguienteCelda();

    }

    public void aplicarModificador(Piquetazo piquetazo) {
        this.sumarMovimientos(this.penalizacionPorPiquetazo);
    }

    public static long probabilidadControl() {
        return 8;
    }

}