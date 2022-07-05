package edu.fiuba.algo3.modelo.modificador;

import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class CambioDeVehiculo implements Modificador {

    private final String nombre = "sorpresa";

    @Override
    public void cruzarCon(Vehiculo vehiculo) {
        vehiculo.aplicarModificador(this);
    }

    @Override
    public String simbolo() {
        return "CV";
    }

    public String getNombre() {
        return nombre;
    }
}
