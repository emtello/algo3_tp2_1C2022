package edu.fiuba.algo3.vista.tablero;

import edu.fiuba.algo3.controlador.ControladorJuego;
import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.tablero.Tablero;
import edu.fiuba.algo3.vista.celda.VistaCelda;
import edu.fiuba.algo3.vista.celda.VistaCeldaCalle;
import edu.fiuba.algo3.vista.celda.VistaCeldaEdificio;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class VistaTablero extends Group {

    private GridPane tabla;
    private Pane[][] celdas;
    private ControladorJuego juego;

    public VistaTablero(ControladorJuego juego) {
        this.juego = juego;
        this.tabla = new GridPane();

        int filas = (this.juego.getFilas() * 2 - 1);
        int columnas = (this.juego.getColumnas() * 2 - 1);

        this.celdas = new Pane[filas][columnas];

        for (int i = 0; i < this.juego.getFilas() * 2 - 1; i++) {
            for (int j = 0; j < this.juego.getColumnas() * 2 - 1; j++ ) {
                VistaCelda celda;
    
                if(i%2==1 && j%2==1){
                    celda = new VistaCeldaEdificio();
                } else if (i % 2 == 0 && j % 2 == 0) {
                    celda = new VistaCeldaCalle();
                } else {
                    celda = new VistaCeldaCalle();
                };
                this.celdas[i][j] = celda;
                this.tabla.add(celda, i, j);
            }
        }

        this.tabla.setAlignment(Pos.CENTER);
        this.agregarVista(this.tabla);
    }

    public void agregarVista(Node nodo) {
        this.getChildren().add(nodo);
    }
    
    public void agregarVistaAPosicion(Node nodo, Celda celda) {
        this.celdas[(int) celda.columna() * 2][(int) celda.fila() * 2].getChildren().add(nodo);
    }

    public void agregarModificadorAPosicion(Node node, Celda origen, Celda destino) {
        long x = origen.fila() * 2 + destino.fila() * 2;
        long y = origen.columna() * 2 + destino.columna() * 2;

        this.celdas[(int) y / 2 ][(int) x / 2].getChildren().add(node);
    }

}
