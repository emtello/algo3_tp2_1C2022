package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorBotonSiSalirDeJuego;
import edu.fiuba.algo3.modelo.tablero.Tablero;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BotonSiSalirDeJuego extends Button {

   public BotonSiSalirDeJuego(Tablero tablero, Stage stage, Scene scene)  {
       super();
       this.setText("SI");
       this.setMinHeight(20);
       this.setOnAction(new ControladorBotonSiSalirDeJuego(tablero, stage, scene));
   }
}
