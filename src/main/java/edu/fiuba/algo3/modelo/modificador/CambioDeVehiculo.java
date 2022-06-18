package edu.fiuba.algo3.modelo.modificador;

import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.vehiculos.IVehiculo;


public class CambioDeVehiculo implements Modificador {

    @Override
    public void cruzarCon(Jugador jugador) {
        jugador.reemplazarVehiculo();
        jugador.sumarMovimientos(NUMERO_DE_MOVIMIENTOS);
    }

    @Override
    public long aplicarA(IVehiculo vehiculo) {
        return 0;
    }
}
