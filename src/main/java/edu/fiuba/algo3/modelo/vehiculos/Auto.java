package edu.fiuba.algo3.modelo.vehiculos;

import edu.fiuba.algo3.modelo.tablero.Tablero;

public class Auto extends Vehiculo {

    private long penalizacionPorPozo = 3;
    private long penalizacionPorControlPolicial = 3;
    
    public Auto(Tablero tablero) {
        super(tablero);
    }

    public static long probabilidadControl() {
        return 5;
    }

    @Override
    public void reemplazarVehiculo() {        
        Vehiculo reemplazo = new Camioneta4x4(this.tablero);

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
        // Nada
    }

    @Override
    public void controlPolicial() {
        this.sumarMovimientos(this.penalizacionPorControlPolicial);
        this.actualizarASiguienteCelda();
    }

}
