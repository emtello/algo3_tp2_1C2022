package edu.fiuba.algo3.modelo.ciudad;

import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.Set;

import edu.fiuba.algo3.modelo.calle.Calle;
import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.excepcion.CeldaFueraDeRango;
import edu.fiuba.algo3.modelo.modificador.Modificador;
import edu.fiuba.algo3.modelo.operadorCiudad.OperadorCiudad;

public class Ciudad {
    private ArrayList<Celda> celdas;
    private int filas;
    private int columnas;
    private long cantidadModificadores;
    private ArrayList<Calle> calles;
    
    public Ciudad(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.celdas = new ArrayList<Celda>();

        this.generarCaminos();
    }

    private Celda obtenerEsquinaAleatoria() {
        int random = (int) (Math.random() * this.celdas.size());
        return this.celdas.get(random);
    }

    public void setCalles(ArrayList<Calle> calles) {
        this.calles = calles;
    }

    public void setCantidadModificadores(long cantidad) {
        this.cantidadModificadores = cantidad;
    }

    public void setEsquinas(ArrayList<Celda> esquinas) {
        this.celdas = esquinas;
    }

    public void completarAleatorio() {
        Celda esquina = this.obtenerEsquinaAleatoria();
        OperadorCiudad operador = new OperadorCiudad(esquina);
        
        operador.completarAleatorio();
    }

    public Celda buscarCelda(Celda celda) {
        for (Celda c : this.celdas) {
            if (c.equals(celda)) return c;
        }
        throw new CeldaFueraDeRango();
    }

    private void generarCaminos() {
        OperadorCiudad operador = new OperadorCiudad(
            new Celda(1, 1)
        );
        
        operador.generarCaminos(this, this.filas, this.columnas);
    }

    public void agregarModificador(Celda origen, Celda destino, Modificador mod) {
        origen = this.buscarCelda(origen);
        destino = this.buscarCelda(destino);
        
        OperadorCiudad operador = new OperadorCiudad(origen);
        operador.buscarCalle(destino).agregarModificador(mod);
    }

    public void reiniciar() {
        for (Celda celda : this.celdas) celda.borrarModificadores();
    }

    public long cantidadModificadores() {
        return this.cantidadModificadores;
    }

    public ArrayList<Calle> getCalles() {
        return this.calles;
    }

}
