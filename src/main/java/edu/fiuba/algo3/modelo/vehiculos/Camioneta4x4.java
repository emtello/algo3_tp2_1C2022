package edu.fiuba.algo3.modelo.vehiculos;

import edu.fiuba.algo3.modelo.modificador.*;
import edu.fiuba.algo3.modelo.tablero.Tablero;

public class Camioneta4x4 extends Vehiculo{

    private long pozosAtravezados = 0;
    private long penalizacionPorPozo = 2;
    private long penalizacionPorControlPolicial = 3;

    public Camioneta4x4(Tablero tablero) {
        super(tablero);
        this.nombre = "camioneta";
    }

    public Camioneta4x4(Vehiculo vehiculo) {
        super(vehiculo);
        this.nombre = "camioneta";
    }

    @Override
    public void aplicarModificador(Modificador modificador) {

    }

    @Override
    public void aplicarModificador(Pozo pozo) {
        this.pozosAtravezados ++;

        if(this.pozosAtravezados > 3) {
            this.sumarMovimientos(this.penalizacionPorPozo);
        };

        this.actualizarASiguienteCelda();
    }

    @Override
    public void aplicarModificador(Piquete piquete) {
        //Nada
    }

    @Override
    public void aplicarModificador(ControlPolicial controlPolicial) {
        this.sumarMovimientos(this.penalizacionPorControlPolicial);
        this.actualizarASiguienteCelda();
    }

    @Override
    public void aplicarModificador(CambioDeVehiculo cambioDeVehiculo) {
        // Vehiculo reemplazo = new Moto(this.tablero);
        Vehiculo reemplazo = new Moto(this);

        // reemplazo.asignarCeldaInicial(this.celdaInicial);
        // reemplazo.sumarMovimientos(this.movimientos);
        // reemplazo.setObservadores(this.observadores);

        this.tablero.reemplazarVehiculo(reemplazo);
        reemplazo.actualizarASiguienteCelda();
        //this.actualizarASiguienteCelda();
    }

    public static long probabilidadControl() {
        return 3;
    }

}
