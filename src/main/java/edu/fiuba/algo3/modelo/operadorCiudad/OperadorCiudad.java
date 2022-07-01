package edu.fiuba.algo3.modelo.operadorCiudad;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.calle.Calle;
import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import edu.fiuba.algo3.modelo.modificador.ControlPolicial;
import edu.fiuba.algo3.modelo.modificador.Desfavorable;
import edu.fiuba.algo3.modelo.modificador.Favorable;
import edu.fiuba.algo3.modelo.modificador.Modificador;
import edu.fiuba.algo3.modelo.modificador.Nulo;
import edu.fiuba.algo3.modelo.modificador.Piquete;
import edu.fiuba.algo3.modelo.modificador.Pozo;

public class OperadorCiudad {

    private Celda nodoInicial;
    
    public OperadorCiudad(Celda nodoInicial) {
        this.nodoInicial = nodoInicial;
    }

    private ArrayList<Modificador> obtenerModificadores() { 
        ArrayList<Modificador> mod = new ArrayList<Modificador>();
        mod.add(new Nulo());
        mod.add(new Pozo());
        mod.add(new Piquete());
        mod.add(new ControlPolicial());
        mod.add(new Favorable());
        mod.add(new Desfavorable());

        return mod;
    }

    public void completarAleatorio() {
        Celda celdaInicial = this.nodoInicial;
        ArrayList<Modificador> mod = this.obtenerModificadores();
        
        // Se recorre el grafo haciendo un bfs

        ArrayList<Celda> visitados = new ArrayList<Celda>();
        ArrayList<Celda> cola = new ArrayList<Celda>();
        
        visitados.add(celdaInicial);
        cola.add(celdaInicial);
    
        while (!cola.isEmpty()) {
            Celda actual = cola.remove(0);
            
            for (Calle calle : actual.calles()) {
                Celda esquina = calle.siguienteEsquina(actual);

                if (!visitados.contains(esquina)) {
                    int random = (int) (Math.random() * mod.size());
                    
                    calle.agregarModificador(mod.get(random));
                    visitados.add(esquina);
                    cola.add(esquina);

                }
            }
        }
    }

    public void generarCaminos(Ciudad ciudad, long f, long c) {
        ArrayList<Celda> visitados = new ArrayList<Celda>();
        ArrayList<Celda> cola = new ArrayList<Celda>();

        cola.add(this.nodoInicial);
        visitados.add(this.nodoInicial);
        long cm = 0;
       
        while (!cola.isEmpty()) {
            Celda actual = cola.remove(0);

            // Se evitan los bordes por comodidad, pues son contemplados
            // al relacionar bidereccionalmente desde una esquina interna

            if (this.esquinaEsBorde(actual, f, c)) continue;

            cm = cm + this.generarAdyacencias(actual, visitados, f, c);
            
            for (Calle calle : actual.calles()) {
                Celda esquina = calle.siguienteEsquina(actual);

                if (!visitados.contains(esquina)) {
                    cola.add(esquina);
                    visitados.add(esquina);
                }
            }
        }

        ciudad.setCantidadModificadores(cm);
        ciudad.setEsquinas(visitados);
    
    }

    private void generarCalle(Celda esq1, Celda esq2, Modificador mod) {
        Calle calle = new Calle(esq1, esq2, mod);

        esq1.agregarCalle(calle);
        esq2.agregarCalle(calle);
    }

    private long generarAdyacencias(Celda esqActual,  ArrayList<Celda> vtd, long f, long c) {
        long i = esqActual.fila();
        long j = esqActual.columna();

        long cantidadModificadores = 0;

        ArrayList<Celda> celdasAdyacentes = new ArrayList<Celda>();
        celdasAdyacentes.add(new Celda(i - 1, j));
        celdasAdyacentes.add(new Celda(i, j - 1));
        celdasAdyacentes.add(new Celda(i, j + 1));
        celdasAdyacentes.add(new Celda(i + 1, j));

        // No se hace visitadas.contains porque no es la misma referencia
        // entonces nunca la detectara como visitada

        for (Celda celdaAdyacente : celdasAdyacentes) {
            Boolean ok = true;
            for (Celda celdaVisitada : vtd) {
                if (celdaAdyacente.equals(celdaVisitada)) {
                    ArrayList<Calle> calles = celdaVisitada.calles();
                    for (Calle calle : calles) {
                        Celda esquina = calle.siguienteEsquina(celdaVisitada);
                        if (esquina.equals(esqActual)) {
                            ok = false;
                            break;
                        }
                    }
                }
            }
            
            if (!ok) continue;
            
            this.generarCalle(esqActual, celdaAdyacente, new Nulo());
            cantidadModificadores++;

        }

        return cantidadModificadores;
        
    }

    public Boolean esquinaEsBorde(Celda esqActual, long f, long c) {
        long i = esqActual.fila();
        long j = esqActual.columna();
        
        return (i == 0 || j == 0 || i == f - 1 || j == c - 1);
    }

    public Calle buscarCalle(Celda destino) {
        for (Calle calle : this.nodoInicial.calles()) {
            if (calle.siguienteEsquina(nodoInicial).equals(destino)) {
                return calle;
            }
        }

        throw new Error("No se encontro la calle");
    }

}
