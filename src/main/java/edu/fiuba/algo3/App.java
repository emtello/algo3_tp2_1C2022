package edu.fiuba.algo3;

import edu.fiuba.algo3.controlador.ControladorVehiculo;
import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.tablero.Tablero;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;
import edu.fiuba.algo3.vista.BotonIrAMenu;
import edu.fiuba.algo3.vista.ContenedorDeBoton;
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

    private Stage escenario;
    private Scene escenaJuego;
    private VBox vbox1;
    private VBox contenedor;
    private BotonIrAMenu botonIrAMenu;

    private Scene escenaMenu;
    private VBox vbox2;
    private Button botonIrAJuego;
    private Button botonIrAPuntajes;

    private Button botonNoJuego;
    private Button botonSiJuego;

    private Button botonNoMenu;
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

        Tablero tablero = new Tablero(10, 10);
        Vehiculo vehiculo = new Moto(tablero);

        tablero.agregarvehiculo(vehiculo);
        tablero.iniciarEn(new Celda(4, 4));

        this.vistaTablero = new VistaTablero(tablero);
        this.vistaVehiculo = new VistaVehiculo(this.vistaTablero, vehiculo);
        this.vistaVehiculo.setFocusTraversable(true);

        ControladorVehiculo controlador = new ControladorVehiculo(tablero);

        vehiculo.addObserver(vistaVehiculo);

        botonIrAMenu = new BotonIrAMenu(escenario, escenaSalirDeJuego);
        //botonIrAMenu.setOnAction(e -> cambiarEscenas(escenaSalirDeJuego));
        botonIrAMenu.setFocusTraversable(false);

        contenedor = new VBox();

        contenedor.getChildren().add(this.vistaTablero);
        contenedor.getChildren().add(this.vistaVehiculo);
        contenedor.setOnKeyPressed(controlador);

        contenedor.getChildren().add(botonIrAMenu);

        contenedor.setAlignment(Pos.CENTER);

        escenaJuego = new Scene(contenedor, 640, 640);
        return escenaJuego;

    }

    private Scene crearEscenaMenu() {
        Label label = new Label("Nombre:");
        TextField textField = new TextField();
        textField.setPromptText("Ingresar nombre");
        textField.setFocusTraversable(false);
        textField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println(textField.getText());
            }
        });

        botonIrAPuntajes = new Button("Mejores Puntajes");
        botonIrAPuntajes.setOnAction(e -> cambiarEscenas(escenaMejoresPuntajes));
        botonIrAJuego = new Button("Clickear para Jugar");
        botonIrAJuego.setOnAction(e -> cambiarEscenas(escenaSalirDeMenu));
        vbox2 = new VBox(label, textField, botonIrAJuego, botonIrAPuntajes);
        vbox2.setAlignment(Pos.CENTER);

        escenaMenu = new Scene(vbox2, 640, 640);
        return escenaMenu;
    }

    private Scene crearEscenaMejoresPuntajes() {
        Label label = new Label("Mejores Puntajes");

        Button botonSalirDePuntajes = new Button("Clickear para ir al Menu");
        botonSalirDePuntajes.setOnAction(e -> cambiarEscenas(escenaSalirDeMejoresPuntajes));
        VBox vbox6 = new VBox(label, botonSalirDePuntajes);
        vbox6.setAlignment(Pos.CENTER);
        escenaMejoresPuntajes = new Scene(vbox6, 640, 640);
        return escenaMejoresPuntajes;
    }

    public void cambiarEscenas(Scene escena){
        escenario.setScene(escena);
    }

    private Scene crearEscenaSalirDeMenu() {

        Label label = new Label("Desea ir al Juego?");

        botonNoMenu = new Button("NO");
        botonNoMenu.setOnAction(e -> cambiarEscenas(escenaMenu));
        botonSiMenu = new Button("SI");
        botonSiMenu.setOnAction(e -> cambiarEscenas(escenaJuego));
        VBox vbox7 = new VBox(label, botonNoMenu, botonSiMenu);
        vbox7.setAlignment(Pos.CENTER);
        escenaSalirDeMenu= new Scene(vbox7, 640, 640);

        return escenaSalirDeMenu;
    }

    private Scene crearEscenaSalirDeJuego() {

        Label label = new Label("Desea ir al Menu?");

        botonNoJuego = new Button("NO");
        botonNoJuego.setOnAction(e -> cambiarEscenas(escenaJuego));
        botonSiJuego = new Button("SI");
        botonSiJuego.setOnAction(e -> cambiarEscenas(escenaMenu));
        VBox vbox8 = new VBox(label, botonNoJuego, botonSiJuego);
        vbox8.setAlignment(Pos.CENTER);
        escenaSalirDeJuego= new Scene(vbox8, 640, 640);
        return escenaSalirDeJuego;

    }

    private Scene crearEscenaSalirDeMejoresPuntajes() {

        Label label = new Label("Desea ir al Menu?");

        Button botonNoMenu2 = new Button("NO");
        botonNoMenu2.setOnAction(e -> cambiarEscenas(escenaMejoresPuntajes));
        Button botonSiMenu2 = new Button("SI");
        botonSiMenu2.setOnAction(e -> cambiarEscenas(escenaMenu));
        VBox vbox9 = new VBox(label, botonNoMenu2, botonSiMenu2);
        vbox9.setAlignment(Pos.CENTER);
        escenaSalirDeMejoresPuntajes = new Scene(vbox9, 640, 640);

        return escenaSalirDeMejoresPuntajes;
    }

    public static void main(String[] args) {
        launch();
    }

}