package edu.fiuba.algo3.modelo.vehiculos;

import edu.fiuba.algo3.modelo.tablero.Tablero;

public class Moto extends Vehiculo{

    private long penalizacionPorPozo = 3;
    private long penalizacionPorPiquete = 2;
    private long penalizacionPorControlPolicial = 3;
    
    public Moto(Tablero tablero) {
        super(tablero);
    }

    public static long probabilidadControl() {
        return 8;
    }

    @Override
    public void reemplazarVehiculo() {
        Vehiculo reemplazo = new Auto(this.tablero);

        reemplazo.asignarCeldaInicial(this.celdaInicial);
        reemplazo.sumarMovimientos(this.movimientos);

        this.tablero.reemplazarVehiculo(reemplazo);

        this.actualizarASiguienteCelda();
    }

    @Override
    public void pozo() {
        this.sumarMovimientos(this.penalizacionPorPozo);
        this.actualizarASiguienteCelda();
    }

    @Override
    public void piquete() {
        this.sumarMovimientos(this.penalizacionPorPiquete);
        this.actualizarASiguienteCelda();
    }

    @Override
    public void controlPolicial() {
        this.sumarMovimientos(this.penalizacionPorControlPolicial);
        this.actualizarASiguienteCelda();
    }
    
}