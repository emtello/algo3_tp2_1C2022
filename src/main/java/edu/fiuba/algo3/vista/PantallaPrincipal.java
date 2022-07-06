package edu.fiuba.algo3.vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PantallaPrincipal {

    
    public Scene render() {
         
        var botonIniciar = new Button("Iniciar juego");
        var botonSalir = new Button("Salir");

        botonIniciar.setOnAction(e -> 
            System.out.print("HOLA")
        );
        var contenedorHorizontal = new HBox(botonIniciar, botonSalir);
        contenedorHorizontal.setAlignment(Pos.CENTER);
        contenedorHorizontal.setSpacing(10);

        
        var tituloJuego = new Label("Juego");
        var contenedorVertical = new VBox(tituloJuego, contenedorHorizontal);
        contenedorVertical.setPadding(new Insets(10));
        contenedorVertical.setAlignment(Pos.CENTER);

        return new Scene(contenedorVertical);
    }
    
}
