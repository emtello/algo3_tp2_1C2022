package edu.fiuba.algo3.modelo.modificador;

import edu.fiuba.algo3.modelo.jugador.Jugador;

public class Favorable implements Modificador {

    @Override
    public void cruzarCon(Jugador jugador) {
        jugador.sorpresaFavorable();
        jugador.sumarMovimientos(1);
    }
    
}