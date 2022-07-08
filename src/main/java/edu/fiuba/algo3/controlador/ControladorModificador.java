package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.calle.Calle;
import edu.fiuba.algo3.modelo.celda.Celda;

public class ControladorModificador {
    
    public static String obtenerModificador(Celda origen, Celda destino) {
        for (Calle calle : origen.calles()) {
            Celda siguiente = calle.siguienteEsquina(origen);
            if (siguiente.equals(destino)) {
                return calle.getModificador().getNombre();
            }
        }

        return null;
    }

}
