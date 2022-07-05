package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorBotonSi;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BotonSi extends Button {
    public BotonSi(Stage stage, Scene scene)  {
        super();
        this.setText("SI");
        this.setMinHeight(20);
        this.setOnAction(new ControladorBotonSi(stage, scene));
    }
}
