package edu.fiuba.algo3.vista.modificador;

import edu.fiuba.algo3.controlador.ControladorModificador;
import edu.fiuba.algo3.controlador.Observer;
import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.vista.tablero.VistaTablero;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class VistaModificador extends Group implements Observer {

    private ImageView pane;
    private String modificador;
    private Celda origen;
    private Celda destino;

    public VistaModificador(VistaTablero vistaTablero, Celda origen, Celda destino) {
        this.pane = new ImageView();
        this.modificador = actualizarModificador(origen, destino);
        this.origen = origen;
        this.destino = destino;
        
        // Para optimizar
        if (modificador != "nulo") {
            Image image = new Image(modificador + ".png");
            
            this.pane = new ImageView(image);
            this.pane.setFitHeight(20);
            this.pane.setFitWidth(20);
    
            vistaTablero.agregarModificadorAPosicion(this.pane, origen, destino);
        }
    }

    public String actualizarModificador(Celda origen, Celda destino) {
        return ControladorModificador.obtenerModificador(origen, destino);
    }

    @Override
    public void update() {
        this.modificador = actualizarModificador(origen, destino);
        this.pane.setImage(new Image(this.modificador + ".png")); 
    }
    
}
