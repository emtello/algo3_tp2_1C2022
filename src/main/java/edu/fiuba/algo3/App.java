package edu.fiuba.algo3;

import edu.fiuba.algo3.controlador.ControladorVehiculo;
import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.tablero.Tablero;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;
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
    private Button boton1;

    private Scene escenaMenu;
    private VBox vbox2;
    private Button boton2;
    private Button botonPuntajes;

    private Button botonNo;
    private Button botonSi;

    private Button botonNoMenu;
    private Button botonSiMenu;

    private Scene escenaMejoresPuntajes;
    private Scene escenaSalirDeJuego;
    private Scene escenaSalirDeMenu;

    private Scene escenaSalirDeMejoresPuntajes;


    @Override
    public void start(Stage stage) {

        escenario = stage;
        escenario.setTitle("Cambiando de escenas");

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

        boton1 = new Button("Clickear para ir a Menu");
        boton1.setOnAction(e -> cambiarEscenas(escenaSalirDeJuego));
        boton1.setFocusTraversable(false);

        contenedor = new VBox();

        contenedor.getChildren().add(this.vistaTablero);
        contenedor.getChildren().add(this.vistaVehiculo);
        contenedor.setOnKeyPressed(controlador);

        contenedor.getChildren().add(boton1);

        contenedor.setAlignment(Pos.CENTER);

        escenaJuego = new Scene(contenedor, 400, 700);
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

        botonPuntajes = new Button("Mejores Puntajes");
        botonPuntajes.setOnAction(e -> cambiarEscenas(escenaMejoresPuntajes));
        boton2 = new Button("Clickear para Jugar");
        boton2.setOnAction(e -> cambiarEscenas(escenaSalirDeMenu));
        vbox2 = new VBox(label, textField, boton2, botonPuntajes);

        escenaMenu = new Scene(vbox2, 400, 700);
        return escenaMenu;
    }

    private Scene crearEscenaMejoresPuntajes() {
        Label label = new Label("Mejores Puntajes");

        Button botonSalirDePuntajes = new Button("Clickear para ir al Menu");
        botonSalirDePuntajes.setOnAction(e -> cambiarEscenas(escenaSalirDeMejoresPuntajes));
        vbox2 = new VBox(label, botonSalirDePuntajes);

        escenaMejoresPuntajes = new Scene(vbox2, 400, 700);
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
        vbox2 = new VBox(label, botonNoMenu, botonSiMenu);

        escenaSalirDeMenu= new Scene(vbox2, 400, 700);

        return escenaSalirDeMenu;
    }

    private Scene crearEscenaSalirDeJuego() {

        Label label = new Label("Desea ir al Menu?");

        botonNo = new Button("NO");
        botonNo.setOnAction(e -> cambiarEscenas(escenaJuego));
        botonSi = new Button("SI");
        botonSi.setOnAction(e -> cambiarEscenas(escenaMenu));
        vbox2 = new VBox(label, botonNo, botonSi);

        escenaSalirDeJuego= new Scene(vbox2, 400, 700);
        return escenaSalirDeJuego;

    }

    private Scene crearEscenaSalirDeMejoresPuntajes() {

        Label label = new Label("Desea ir al Menu?");

        Button botonNoMenu2 = new Button("NO");
        botonNoMenu2.setOnAction(e -> cambiarEscenas(escenaMejoresPuntajes));
        Button botonSiMenu2 = new Button("SI");
        botonSiMenu2.setOnAction(e -> cambiarEscenas(escenaMenu));
        vbox2 = new VBox(label, botonNoMenu2, botonSiMenu2);

        escenaSalirDeMejoresPuntajes = new Scene(vbox2, 400, 700);

        return escenaSalirDeMejoresPuntajes;
    }

    public static void main(String[] args) {
        launch();
    }

}