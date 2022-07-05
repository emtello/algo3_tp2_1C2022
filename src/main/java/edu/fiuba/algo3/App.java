package edu.fiuba.algo3;

import java.util.ArrayList;

import edu.fiuba.algo3.controlador.ControladorVehiculo;
import edu.fiuba.algo3.modelo.calle.Calle;
import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.modificador.Favorable;
import edu.fiuba.algo3.modelo.tablero.Tablero;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;
import edu.fiuba.algo3.vista.modificador.VistaModificador;
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
        Vehiculo vehiculo = new Auto(tablero);

        tablero.agregarModificador(new Celda(0, 0), new Celda(1, 0), new Favorable());

        VistaModificador vistaModificadores[] = new VistaModificador[tablero.getFilas()];

        tablero.agregarvehiculo(vehiculo);
        tablero.iniciarEn(new Celda(4, 4));

        this.vistaTablero = new VistaTablero(tablero);
        
        for (Calle calle : tablero.getCalles()) {
            ArrayList<Celda> esquinas = calle.obtenerEsquinas();
            String nombre = calle.getModificador().getNombre();
            
            VistaModificador vista = new VistaModificador(this.vistaTablero, nombre, esquinas.get(0), esquinas.get(1));
            calle.addObserver(vista);
        }
        
        
        this.vistaVehiculo = new VistaVehiculo(this.vistaTablero, vehiculo.getNombre(), vehiculo.getPosicion());
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

        botonPuntajes = new Button("Mejores Puntajes");
        botonPuntajes.setOnAction(e -> cambiarEscenas(escenaMejoresPuntajes));
        boton2 = new Button("Clickear para Jugar");
        boton2.setOnAction(e -> cambiarEscenas(escenaSalirDeMenu));
        vbox2 = new VBox(label, textField, boton2, botonPuntajes);
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

        botonNo = new Button("NO");
        botonNo.setOnAction(e -> cambiarEscenas(escenaJuego));
        botonSi = new Button("SI");
        botonSi.setOnAction(e -> cambiarEscenas(escenaMenu));
        VBox vbox8 = new VBox(label, botonNo, botonSi);
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