package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorBotonIrAPuntajes;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BotonIrAPuntajes extends Button {
    public BotonIrAPuntajes(Stage stage, Scene scene) {
        super();
        this.setText("Mejores Puntajes");
        this.setMinHeight(20);
        this.setOnAction(new ControladorBotonIrAPuntajes(stage, scene));
    }

}
