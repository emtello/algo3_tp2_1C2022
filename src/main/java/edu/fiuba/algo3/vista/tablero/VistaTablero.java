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
        int filas = tablero.getFilas() * (int) dimensionCelda;
        int columnas = tablero.getColumnas() * (int) dimensionCelda;

        this.celdas = new Pane[filas][columnas];

        for (int i = 0; i < tablero.getFilas(); i++) {
            for (int j = 0; j < tablero.getColumnas(); j++ ) {
                Pane celda = new Pane();
                celda.setMinHeight(dimensionCelda);
                celda.setMinWidth(dimensionCelda);
                celda.setBackground(new Background(new BackgroundFill(Color.GREY, CornerRadii.EMPTY, Insets.EMPTY)));
                this.celdas[i][j] = celda;
                this.tabla.add(celda, i, j);
            }
        }
        this.tabla.setVgap(2 * dimensionCelda);
        this.tabla.setHgap(2 * dimensionCelda);

        this.tabla.setAlignment(Pos.CENTER);
        this.agregarVista(this.tabla);
    }

    public void agregarVista(Node nodo) {
        this.getChildren().add(nodo);
    }
    
    public void agregarVistaAPosicion(Node nodo, Celda celda) {
        this.celdas[(int) celda.fila()][(int) celda.columna()].getChildren().add(nodo);
    }
    

}
