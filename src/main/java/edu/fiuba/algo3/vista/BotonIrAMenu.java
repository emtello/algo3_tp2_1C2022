package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorBotonIrAMenu;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BotonIrAMenu extends Button {

    public BotonIrAMenu(Stage stage, Scene scene) {
        super();
        this.setText("Menu");
        this.setMinHeight(20);
        this.setOnAction(new ControladorBotonIrAMenu(stage, scene));
    }
}
