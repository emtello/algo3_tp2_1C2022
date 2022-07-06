package edu.fiuba.algo3;

import edu.fiuba.algo3.controlador.ControladorVehiculo;
import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.tablero.Tablero;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;
import edu.fiuba.algo3.vista.*;
import edu.fiuba.algo3.vista.tablero.VistaTablero;
import edu.fiuba.algo3.vista.vehiculo.VistaVehiculo;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private VistaTablero vistaTablero;
    private VistaVehiculo vistaVehiculo;

    private Tablero tablero;

    private Stage escenario;

    private Scene escenaJuego;
    private VBox contenedor;
    private BotonIrAMenu botonIrAMenu;

    private Scene escenaMenu;
    private VBox vbox2;
    private BotonIrAJuego botonIrAJuego;
    private BotonIrAPuntajes botonIrAPuntajes;

    private Button botonNoJuego;
    private BotonSiSalirDeJuego botonSiJuego;

    private BotonNo botonNoMenu;
    private Button botonSiMenu;

    private Scene escenaMejoresPuntajes;
    private Scene escenaSalirDeJuego;
    private Scene escenaSalirDeMenu;
    private Scene escenaSalirDeMejoresPuntajes;


    @Override
    public void start(Stage stage) {

        escenario = stage;
        escenario.setTitle("GPS Challenge");

        escenaJuego = crearEscenaJuego();
        escenaMenu = crearEscenaMenu();
        escenaSalirDeJuego = crearEscenaSalirDeJuego();
        escenaMejoresPuntajes = crearEscenaMejoresPuntajes();
        escenaSalirDeMenu = crearEscenaSalirDeMenu();
        escenaSalirDeMejoresPuntajes = crearEscenaSalirDeMejoresPuntajes();

        escenario.setScene(escenaMenu);
        escenario.show();

    }

    private Scene crearEscenaJuego() {

        this.tablero = new Tablero(10, 10);
        Vehiculo vehiculo = new Moto(tablero);

        tablero.agregarvehiculo(vehiculo);
        tablero.iniciarEn(new Celda(4, 4));

        this.vistaTablero = new VistaTablero(tablero);
        this.vistaVehiculo = new VistaVehiculo(this.vistaTablero, vehiculo);
        this.vistaVehiculo.setFocusTraversable(true);

        ControladorVehiculo controlador = new ControladorVehiculo(tablero);

        vehiculo.addObserver(vistaVehiculo);

        botonIrAMenu = new BotonIrAMenu(this.escenario, crearEscenaSalirDeJuego());
        botonIrAMenu.setFocusTraversable(false);

        contenedor = new VBox();

        contenedor.getChildren().add(this.vistaTablero);
        contenedor.getChildren().add(this.vistaVehiculo);
        contenedor.setOnKeyPressed(controlador);

        contenedor.getChildren().add(botonIrAMenu);

        contenedor.setAlignment(Pos.CENTER);

        contenedor.setSpacing(10);

        escenaJuego = new Scene(contenedor, 640, 640);

        return escenaJuego;
    }

    private Scene crearEscenaMenu() {

        Label label = new Label("Nombre:");

        IngresoDeNombre ingresoDeNombre = new IngresoDeNombre(this.tablero);

        botonIrAPuntajes = new BotonIrAPuntajes(this.escenario, crearEscenaMejoresPuntajes());
        botonIrAJuego = new BotonIrAJuego(this.escenario, crearEscenaSalirDeMenu());

        vbox2 = new VBox(label, ingresoDeNombre, botonIrAJuego, botonIrAPuntajes);
        vbox2.setAlignment(Pos.CENTER);
        vbox2.setSpacing(10);

        escenaMenu = new Scene(vbox2, 640, 640);

        return escenaMenu;
    }

    private Scene crearEscenaMejoresPuntajes() {
        Label label = new Label("Mejores Puntajes");

        Button botonSalirDePuntajes = new Button("Clickear para ir al Menu");
        botonSalirDePuntajes.setOnAction(e -> cambiarEscenas(escenaSalirDeMejoresPuntajes));

        VBox vbox6 = new VBox(label, botonSalirDePuntajes);
        vbox6.setAlignment(Pos.CENTER);
        vbox6.setSpacing(10);
        escenaMejoresPuntajes = new Scene(vbox6, 640, 640);
        return escenaMejoresPuntajes;
    }

    public void cambiarEscenas(Scene escena){
        escenario.setScene(escena);
    }

    private Scene crearEscenaSalirDeMenu() {

        Label label = new Label("Desea ir al Juego?");

        botonNoMenu = new BotonNo(escenario, escenaMenu); //se traba, al salir de juego lo deberia cerrar

        botonSiMenu = new Button("SI");
        botonSiMenu.setOnAction(e -> cambiarEscenas(escenaJuego));

        VBox vbox7 = new VBox(label, botonNoMenu, botonSiMenu);
        vbox7.setAlignment(Pos.CENTER);
        vbox7.setSpacing(10);
        escenaSalirDeMenu= new Scene(vbox7, 640, 640);

        return escenaSalirDeMenu;
    }

    private Scene crearEscenaSalirDeJuego() {

        Label label = new Label("Desea ir al Menu?");

        botonNoJuego = new Button("NO");
        botonNoJuego.setOnAction(e -> cambiarEscenas(escenaJuego)); //Se queda sin memoria heap debe ser al crear otro tablero

        botonSiJuego = new BotonSiSalirDeJuego(this.tablero, this.escenario, crearEscenaMenu());

        VBox vbox8 = new VBox(label, botonNoJuego, botonSiJuego);
        vbox8.setAlignment(Pos.CENTER);
        vbox8.setSpacing(10);
        escenaSalirDeJuego= new Scene(vbox8, 640, 640);
        return escenaSalirDeJuego;

    }

    private Scene crearEscenaSalirDeMejoresPuntajes() {

        Label label = new Label("Desea ir al Menu?");

        BotonNo botonNoMenu2 = new BotonNo(this.escenario, crearEscenaMejoresPuntajes());

        BotonSi botonSiMenu2 = new BotonSi(this.escenario, crearEscenaMenu());

        VBox vbox9 = new VBox(label, botonNoMenu2, botonSiMenu2);
        vbox9.setAlignment(Pos.CENTER);
        vbox9.setSpacing(10);

        escenaSalirDeMejoresPuntajes = new Scene(vbox9, 640, 640);

        return escenaSalirDeMejoresPuntajes;
    }

    public static void main(String[] args) {
        launch();
    }

}