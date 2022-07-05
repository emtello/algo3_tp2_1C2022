package edu.fiuba.algo3.modelo.generadorDeCiudad;

import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.Set;

import edu.fiuba.algo3.modelo.calle.Calle;
import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.excepcion.CeldaFueraDeRango;
import edu.fiuba.algo3.modelo.modificador.ControlPolicial;
import edu.fiuba.algo3.modelo.modificador.Desfavorable;
import edu.fiuba.algo3.modelo.modificador.Favorable;
import edu.fiuba.algo3.modelo.modificador.Modificador;
import edu.fiuba.algo3.modelo.modificador.Nulo;
import edu.fiuba.algo3.modelo.modificador.Piquete;
import edu.fiuba.algo3.modelo.modificador.Pozo;

public class GeneradorDeCiudad {
    private Celda[][] celdas;
    private int filas;
    private int columnas;
    private ArrayList<Calle> calles;

    public GeneradorDeCiudad(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.calles = new ArrayList<Calle>();
        this.celdas = new Celda[this.filas][this.columnas];

        this.generarCeldas();
        this.generarCaminos();
    }


    public Celda buscarCelda(Celda celda) {
        for (int i = 0; i < this.filas; i++) {
            for (int j = 0; j < this.columnas; j++) {
                if (this.celdas[i][j].equals(celda)) {
                    return this.celdas[i][j];
                }
            }
        }
        throw new CeldaFueraDeRango();
    }


    private void generarCeldas() {
        for (int i = 0; i < this.filas; i++) {
            for (int j = 0; j < this.columnas; j++) {
                this.celdas[i][j] = new Celda(i, j);
            }
        }
    }

    private void generarCaminos() {
        for (int i = 0; i < this.filas; i++) {
            for (int j = 0; j < this.columnas; j++) {
                if (j != 0) {
                    agregarCeldas(this.celdas[i][j], this.celdas[i][j - 1], new Nulo());
                }
                if (i != 0) {
                    agregarCeldas(this.celdas[i][j], this.celdas[i - 1][j], new Nulo());
                }
                if (j != this.columnas - 1) {
                    agregarCeldas(this.celdas[i][j], this.celdas[i][j + 1], new Nulo());
                }
                if (i != this.filas - 1) {
                    agregarCeldas(this.celdas[i][j], this.celdas[i + 1][j], new Nulo());
                }
            }
        }
    }

    private void agregarCeldas(Celda origen, Celda destino, Modificador modificador) {  
        origen = this.buscarCelda(origen);
        destino = this.buscarCelda(destino);

        Calle calle = new Calle(origen, destino, modificador);

        origen.agregarCalle(calle);
        destino.agregarCalle(calle);

        if (!this.calles.contains(calle)) {
            this.calles.add(calle);
        }
    }  

    public void agregarModificador(Celda origen, Celda destino, Modificador mod) {
        origen = this.buscarCelda(origen);
        destino = this.buscarCelda(destino);

        for (Calle calle : this.calles) {
            if (calle.contiene(origen) && calle.contiene(destino)) {
                calle.agregarModificador(mod);
                return;
            }
        }
    }

    public void reiniciar() {
        for (int i = 0; i < this.filas; i++) {
            for (int j = 0; j < this.columnas; j++) {
                this.celdas[i][j].borrarModificadores();
            }
        }
    }


    public void completarAleatorio() {
        ArrayList<Modificador> mod = new ArrayList<Modificador>();
        mod.add(new Nulo());
        mod.add(new Nulo());
        mod.add(new Nulo());
        mod.add(new Nulo());
        mod.add(new Nulo());
        mod.add(new Nulo());
        mod.add(new Nulo());
        mod.add(new Pozo());
        mod.add(new Piquete());
        mod.add(new ControlPolicial());
        mod.add(new Favorable());
        mod.add(new Desfavorable());

        for (Calle calle : calles) {
            int random = (int) (Math.random() * mod.size());        
            calle.agregarModificador(mod.get(random));
        }
    }

    public ArrayList<Calle> getCalles() {
        return this.calles;
    }

}
