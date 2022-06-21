package edu.fiuba.algo3.modelo.vehiculos;

import edu.fiuba.algo3.modelo.tablero.Tablero;

public class Camioneta4x4 extends Vehiculo{

    private long pozosAtravezados = 0;
    private long penalizacionPorPozo = 2;
    private long penalizacionPorControlPolicial = 3;

    public Camioneta4x4(Tablero tablero) {
        super(tablero);
    }

    public static long probabilidadControl() {
        return 3;
    }

    @Override
    public void reemplazarVehiculo() {
        Vehiculo reemplazo = new Moto(this.tablero);

        reemplazo.asignarCeldaInicial(this.celdaInicial);
        reemplazo.sumarMovimientos(this.movimientos);

        this.tablero.reemplazarVehiculo(reemplazo);

        this.actualizarASiguienteCelda();
    }

    @Override
    public void pozo() {
        this.pozosAtravezados ++;
        
        if(this.pozosAtravezados > 3) {
            this.sumarMovimientos(this.penalizacionPorPozo);
        };

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
