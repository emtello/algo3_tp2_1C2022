package edu.fiuba.algo3.modelo.modificador;

import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class ControlPolicial implements Modificador {

    private final String nombre = "control-policial";

    @Override
    public void cruzarCon(Vehiculo vehiculo) {
        vehiculo.aplicarModificador(this);
    }

    @Override
    public String simbolo() {
        return "CP";
    }

    @Override
    public String getNombre() {
        return nombre;
    }

}
