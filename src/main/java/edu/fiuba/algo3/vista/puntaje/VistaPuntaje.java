package edu.fiuba.algo3.vista.puntaje;

import edu.fiuba.algo3.controlador.ControladorJuego;
import edu.fiuba.algo3.controlador.Observer;
import edu.fiuba.algo3.vista.tablero.VistaTablero;
import javafx.scene.Group;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class VistaPuntaje extends Group implements Observer {

    private HBox contenedor;
    private Text contenedorTexto;
    private long puntaje;
    private VistaTablero vistaTablero;
    private ControladorJuego juego;
    
    public VistaPuntaje(VistaTablero vistaTablero, ControladorJuego juego) {
        this.juego = juego;
        this.puntaje = this.juego.getMovimientos();

        this.vistaTablero = vistaTablero;

        this.contenedorTexto = new Text((String.valueOf(puntaje)));
        this.contenedorTexto.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        this.contenedor = new HBox(this.contenedorTexto);

        this.contenedor.setLayoutX(10);
        this.contenedor.setLayoutY(10);
     
        this.vistaTablero.agregarVista(this.contenedor);
    }

    @Override
    public void update() {
        this.puntaje = this.juego.getMovimientos();
        this.contenedorTexto.setText(String.valueOf(this.puntaje));
        this.vistaTablero.agregarVista(this.contenedor);
    }
    
}
