package edu.fiuba.algo3.vista.modificador;

import java.util.Observable;
import java.util.Observer;

import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.vista.tablero.VistaTablero;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class VistaModificador extends Group implements Observer {

    private ImageView pane;

    public VistaModificador(VistaTablero vistaTablero, String modificador, Celda origen, Celda destino) {
        this.pane = new ImageView();
        
        // Para optimizar
        if (modificador != "nulo") {
            Image image = new Image(modificador + ".png");
            
            this.pane = new ImageView(image);
            this.pane.setFitHeight(20);
            this.pane.setFitWidth(20);
    
            vistaTablero.agregarModificadorAPosicion(this.pane, origen, destino);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        this.pane.setImage(new Image(arg.toString() + ".png")); 
    }
}
