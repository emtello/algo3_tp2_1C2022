package edu.fiuba.algo3.vista.tablero;

import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.tablero.Tablero;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class VistaTablero extends Group {

    private final double dimensionCelda = 20;
    private GridPane tabla;
    private Pane[][] celdas;

    public VistaTablero(Tablero tablero) {
        this.tabla = new GridPane();
        int filas = (tablero.getFilas() * 2 - 1) * (int) dimensionCelda;
        int columnas = (tablero.getColumnas() * 2 - 1 ) * (int) dimensionCelda;
        this.celdas = new Pane[filas][columnas];

        for (int i = 0; i < tablero.getFilas() * 2 - 1; i++) {
            for (int j = 0; j < tablero.getColumnas() * 2 - 1; j++ ) {
                Pane celda = new Pane();
                celda.setMinHeight(dimensionCelda);
                celda.setMinWidth(dimensionCelda);
                if(i%2==1 && j%2==1){
                    celda.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
                }else if (i % 2 == 0 && j % 2 == 0) {
                    celda.setBackground(new Background(new BackgroundFill(Color.GREY, CornerRadii.EMPTY, Insets.EMPTY)));
                } else {
                    // aca se crean las vistas de calles
                    celda.setBackground(new Background(new BackgroundFill(Color.GREY, CornerRadii.EMPTY, Insets.EMPTY)));
                };
                this.celdas[i][j] = celda;
                this.tabla.add(celda, i, j);
            }
        }
        this.tabla.setVgap(0);
        this.tabla.setHgap(0);

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
