package edu.fiuba.algo3.vista.modificador;

import java.util.HashMap;
import java.util.Map;

import edu.fiuba.algo3.controlador.ControladorJuego;
import edu.fiuba.algo3.controlador.Observer;
import edu.fiuba.algo3.modelo.celda.Celda;

public class VistaModificadores implements Observer {
    
    private Map<String, VistaModificador> modificadores;
    private ControladorJuego juego;
    private Celda actual;

    public VistaModificadores(ControladorJuego juego) {
        this.juego = juego;
        this.actual = this.juego.obtenerPosicion();
        this.modificadores = new HashMap<String, VistaModificador>();
    }
    
    public String getKey(Celda ini, Celda fin) {
        String fc1 = Long.toString(ini.fila()) + Long.toString(ini.columna());
        String fc2 = Long.toString(fin.fila()) + Long.toString(fin.columna());
        
        return fc1 + fc2;
    }

    public void agregarAVista(Celda ini, Celda fin, VistaModificador modificador) {
        String key = getKey(ini, fin);

        if (this.modificadores.containsKey(key)) return;

        this.modificadores.put(
            key,
            modificador
        );
    }

    @Override
    public void update() {
        Celda siguiente = this.juego.obtenerPosicion();

        VistaModificador modificador = this.modificadores.get(
            getKey(this.actual, siguiente)
        );
        
        if (modificador == null) {
            modificador = this.modificadores.get(
                getKey(siguiente, this.actual)
            );
        }

        this.actual = siguiente;
        modificador.update();
    }

}
