package edu.fiuba.algo3;

import java.util.ArrayList;

import edu.fiuba.algo3.controlador.ControladorJuego;
import edu.fiuba.algo3.controlador.ControladorVehiculo;
import edu.fiuba.algo3.modelo.calle.Calle;
import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.Camioneta4x4;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;
import edu.fiuba.algo3.vista.celda.VistaCeldaLlegada;
import edu.fiuba.algo3.vista.modificador.VistaModificador;
import edu.fiuba.algo3.vista.modificador.VistaModificadores;
import edu.fiuba.algo3.vista.puntaje.VistaPuntaje;
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

    private ControladorJuego juego;

    private VistaTablero vistaTablero;
    private VistaVehiculo vistaVehiculo;
    private VistaPuntaje vistaPuntaje;

    private Stage escenario;

    private Scene escenaJuego;

    private VBox contenedor;
    private Button boton1;

    private Scene escenaMenu;
    private VBox vbox2;
    private Button boton2;
    private Button botonPuntajes;

    private Button botonNo;
    private Button botonSi;

    private Scene escenaMejoresPuntajes;
    private Scene escenaSalirDeJuego;
    private Scene escenaSalirDeMenu;
    private Scene escenaJuegoCompleto;

    private Scene escenaSalirDeMejoresPuntajes;


    @Override
    public void start(Stage stage) {

        escenario = stage;
        escenario.setTitle("GPS Challenge");

        escenaMenu = crearEscenaMenu();
        escenaSalirDeJuego = crearEscenaSalirDeJuego();
        escenaMejoresPuntajes = crearEscenaMejoresPuntajes();
        escenaSalirDeMenu = crearEscenaSalirDeMenu();
        escenaSalirDeMejoresPuntajes = crearEscenaSalirDeMejoresPuntajes();
        escenaJuegoCompleto = crearEscenaJuegoCompleto();

        escenario.setScene(escenaMenu);
        escenario.show();

    }

    public void iniciarJuego() {
        this.juego = new ControladorJuego(15, 15);
    }

    private Scene crearEscenaJuego() {
        this.vistaTablero = new VistaTablero(this.juego);
        
        this.vistaTablero.agregarVistaAPosicion(
            new VistaCeldaLlegada(), 
            this.juego.getLlegada()
        );
        
        VistaModificadores vistaModificadores = new VistaModificadores(this.juego);
        for (Calle calle : this.juego.getCalles()) {
            ArrayList<Celda> esquinas = calle.obtenerEsquinas();
            
            VistaModificador vista = new VistaModificador(
                this.vistaTablero,
                this.juego,
                esquinas.get(0),
                esquinas.get(1))
            ;

            vistaModificadores.agregarAVista(esquinas.get(0), esquinas.get(1), vista);
        }
        this.juego.agregar(vistaModificadores);

        this.vistaVehiculo = new VistaVehiculo(this.vistaTablero, this.juego);
        this.vistaVehiculo.setFocusTraversable(true);
    
        this.juego.agregar(vistaVehiculo);

        ControladorVehiculo controlador = new ControladorVehiculo(this.juego, this);
        
        this.vistaPuntaje = new VistaPuntaje(this.vistaTablero, this.juego);
        this.juego.agregar(vistaPuntaje);

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

    public void mostrarVentanaJuegoCompleto() {
        this.cambiarEscenas(escenaJuegoCompleto);
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

    public void reiniciarJuego() {
        this.cambiarEscenas(crearEscenaSalirDeMenu());
    }

    private Scene crearEscenaJuegoCompleto() {
        Label label = new Label("Juego Completo");

        Button botonSalirDeJuego = new Button("Clickear para ir al Menu");
        botonSalirDeJuego.setOnAction(e -> cambiarEscenas(escenaSalirDeJuego));

        Button botonReiniciarJuego = new Button("Clickear para reiniciar");
        botonReiniciarJuego.setOnAction(e -> reiniciarJuego());

        VBox vbox5 = new VBox(label, botonSalirDeJuego, botonReiniciarJuego);
        vbox5.setAlignment(Pos.CENTER);

        escenaJuegoCompleto = new Scene(vbox5, 640, 640);
        
        return escenaJuegoCompleto;
    }

    public void cambiarEscenas(Scene escena){
        escenario.setScene(escena);
    }

    public void usarVehiculo(Vehiculo vehiculo) {
        this.juego.usarVehiculo(vehiculo);
        this.cambiarEscenas(crearEscenaJuego());
    }

    private Scene crearEscenaSalirDeMenu() {
        this.iniciarJuego();

        Label label = new Label("Elija un vehiculo");

        Button botonMoto = new Button("Moto");
        botonMoto.setOnAction(e -> usarVehiculo(new Moto(this.juego.getTablero())));
        
        Button botonAuto = new Button("Auto");
        botonAuto.setOnAction(e -> usarVehiculo(new Auto(this.juego.getTablero())));

        Button botonCamioneta4x4 = new Button("Camioneta4x4");
        botonCamioneta4x4.setOnAction(e -> usarVehiculo(new Camioneta4x4(this.juego.getTablero())));
        
        Button botonSalirDeMenu = new Button("Clickear para salir");
        botonSalirDeMenu.setOnAction(e -> cambiarEscenas(escenaSalirDeMenu));
        VBox vbox3 = new VBox(label, botonAuto, botonMoto, botonCamioneta4x4, botonSalirDeMenu);
        vbox3.setAlignment(Pos.CENTER);

        escenaSalirDeMenu = new Scene(vbox3, 640, 640);
        return escenaSalirDeMenu;
    }

    private Scene crearEscenaSalirDeJuego() {
        Label label = new Label("Desea ir al Menu?");

        botonNo = new Button("NO");
        botonNo.setOnAction(e -> cambiarEscenas(crearEscenaJuego()));
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