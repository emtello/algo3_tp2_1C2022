package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorBotonNo;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BotonNo extends Button {
    public BotonNo(Stage stage, Scene scene)  {
        super();
        this.setText("NO");
        this.setMinHeight(20);
        this.setOnAction(new ControladorBotonNo(stage, scene));
    }
}
