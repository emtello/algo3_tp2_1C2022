package edu.fiuba.algo3.modelo.modificador;

import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class Desfavorable implements Modificador, Sorpresa {

    private final String nombre = "sorpresa";

    @Override
    public void cruzarCon(Vehiculo vehiculo) {
        vehiculo.sorpresa(this);
    }

    @Override
    public long aplicarSorpresa(long movimientos) {
        return (Math.toIntExact(Math.round(
            movimientos * 1.25
        )));
    }

    @Override
    public String simbolo() {
        return "DE";
    }
    
    public String getNombre() {
        return nombre;
    }

}
