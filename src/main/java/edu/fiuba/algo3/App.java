package edu.fiuba.algo3;

import java.util.ArrayList;

import edu.fiuba.algo3.controlador.ControladorJuego;
import edu.fiuba.algo3.controlador.ControladorRegistro;
import edu.fiuba.algo3.controlador.ControladorVehiculo;
import edu.fiuba.algo3.modelo.calle.Calle;
import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.registro.Puntaje;
import edu.fiuba.algo3.modelo.vehiculos.*;
import edu.fiuba.algo3.vista.celda.VistaCeldaLlegada;
import edu.fiuba.algo3.vista.modificador.VistaModificador;
import edu.fiuba.algo3.vista.modificador.VistaModificadores;
import edu.fiuba.algo3.vista.puntaje.VistaPuntaje;
import edu.fiuba.algo3.vista.*;
import edu.fiuba.algo3.vista.tablero.VistaTablero;
import edu.fiuba.algo3.vista.vehiculo.VistaVehiculo;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static javafx.scene.control.TableView.CONSTRAINED_RESIZE_POLICY;

/**
 * JavaFX App
 */
public class App extends Application {

    private TableView<Puntaje> tablaDePuntajes;
    private ControladorJuego juego;
    private ControladorRegistro registro;

    private VistaTablero vistaTablero;
    private VistaVehiculo vistaVehiculo;
    private VistaPuntaje vistaPuntaje;

    private Stage escenario;

    private Scene escenaJuego;
    private VBox contenedor;
    private BotonIrAMenu botonIrAMenu;

    private Scene escenaMenu;
    private VBox vbox2;
    private BotonIrAJuego botonIrAJuego;
    private Button botonIrAPuntajes;

    // private Button botonNoJuego;
    // private BotonSiSalirDeJuego botonSiJuego;

    // private BotonNo botonNoMenu;
    // private Button botonSiMenu;

    private Scene escenaMejoresPuntajes;
    private Scene escenaSalirDeJuego;
    private Scene escenaSalirDeMenu;
    private Scene escenaJuegoCompleto;

    private Scene escenaSalirDeMejoresPuntajes;


    @Override
    public void start(Stage stage) {
        this.iniciarRegistro();
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
        this.juego = new ControladorJuego(8, 8);
    }

    public void iniciarRegistro() {
        this.registro = new ControladorRegistro();
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

        Label label = new Label("Bienvenido al GPS Challenge");

        // IngresoDeNombre ingresoDeNombre = new IngresoDeNombre();

        // botonIrAPuntajes = new BotonIrAPuntajes(this.escenario, crearEscenaMejoresPuntajes());
        botonIrAPuntajes = new Button("Ir a puntajes");
        botonIrAPuntajes.setOnAction(e -> cambiarEscenas(crearEscenaMejoresPuntajes()));

        Button botonIrAlJuego = new Button("Jugar");
        botonIrAlJuego.setOnAction(e -> this.reiniciarJuego());

        // botonIrAJuego = new BotonIrAJuego(this.escenario, crearEscenaSalirDeMenu());

        vbox2 = new VBox(label, botonIrAlJuego, botonIrAPuntajes);
        vbox2.setAlignment(Pos.CENTER);
        vbox2.setSpacing(10);
        vbox2.setPadding(new Insets(20));

        escenaMenu = new Scene(vbox2, 640, 640);

        return escenaMenu;
    }

    private TableView<Puntaje> crearTablaDePuntajes() {

        tablaDePuntajes = new TableView<>();

        //Columna Usuarios
        TableColumn<Puntaje, String> columnaUsuario = new TableColumn<>("Usuario");
        columnaUsuario.setMinWidth(20);
        columnaUsuario.setCellValueFactory(new PropertyValueFactory<Puntaje, String>("usuario"));

        //Columna Puntajes
        TableColumn<Puntaje, Long> columnaPuntaje = new TableColumn<>("Puntaje");
        columnaPuntaje.setMinWidth(20);
        columnaPuntaje.setCellValueFactory(new PropertyValueFactory<Puntaje, Long>("puntaje"));

        tablaDePuntajes.getColumns().add(columnaUsuario);
        tablaDePuntajes.getColumns().add(columnaPuntaje);
        tablaDePuntajes.setColumnResizePolicy(CONSTRAINED_RESIZE_POLICY);
        tablaDePuntajes.setItems(getPuntajes());

        return tablaDePuntajes;
    }

    public ObservableList<Puntaje> getPuntajes() { //HACER LISTA SOLO 5
        ObservableList<Puntaje> puntajes = FXCollections.observableArrayList();

        puntajes.addAll(this.registro.getPuntajes());

        return puntajes;
    }

    public void mostrarVentanaJuegoCompleto() {
        escenaJuegoCompleto = crearEscenaJuegoCompleto();
        this.cambiarEscenas(escenaJuegoCompleto);
    }

    private Scene crearEscenaMejoresPuntajes() {
        Label label = new Label("Mejores Puntajes");

        Button botonSalirDePuntajes = new Button("Clickear para ir al Menu");
        botonSalirDePuntajes.setOnAction(e -> cambiarEscenas(escenaSalirDeMejoresPuntajes)); //Stack overflow

        VBox vbox6 = new VBox(10, label, crearTablaDePuntajes(), botonSalirDePuntajes);
        vbox6.setAlignment(Pos.CENTER);
        vbox6.setPadding(new Insets(20));

        escenaMejoresPuntajes = new Scene(vbox6, 640, 640);

        return escenaMejoresPuntajes;
    }

    public void reiniciarJuego() {
        this.cambiarEscenas(crearEscenaSalirDeMenu());
    }

    private Scene crearEscenaJuegoCompleto() {
        Label label = new Label("Juego Completo");

        Label labelIngreso = new Label("Ingrese su nombre para registrarlo");
        TextField ingresoNombre = new TextField();

        Button botonIngresoNombre = new Button("Guardar puntación");
        botonIngresoNombre.setOnAction(e -> registro.registrar(botonIngresoNombre, ingresoNombre, this.juego));

        Button botonSalirDeJuego = new Button("Clickear para ir al Menu");
        botonSalirDeJuego.setOnAction(e -> cambiarEscenas(escenaSalirDeJuego));

        Button botonReiniciarJuego = new Button("Clickear para reiniciar");
        botonReiniciarJuego.setOnAction(e -> reiniciarJuego());

        VBox vbox5 = new VBox(
            label, 
            labelIngreso,
            ingresoNombre,
            botonIngresoNombre,
            botonSalirDeJuego, 
            botonReiniciarJuego
        );
        vbox5.setSpacing(10);
        vbox5.setPadding(new Insets(10));
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

        Button botonReliant = new Button("Reliant Robin");
        botonReliant.setOnAction(e -> usarVehiculo(new ReliantRobin(this.juego.getTablero())));
        
        Button botonAuto = new Button("Auto");
        botonAuto.setOnAction(e -> usarVehiculo(new Auto(this.juego.getTablero())));

        Button botonCamioneta4x4 = new Button("Camioneta4x4");
        botonCamioneta4x4.setOnAction(e -> usarVehiculo(new Camioneta4x4(this.juego.getTablero())));
        
        Button botonSalirDeMenu = new Button("Clickear para salir");
        botonSalirDeMenu.setOnAction(e -> cambiarEscenas(escenaMenu));
        VBox vbox3 = new VBox(label, botonMoto, botonAuto, botonReliant, botonCamioneta4x4, botonSalirDeMenu);
        
        vbox3.setAlignment(Pos.CENTER);
        vbox3.setSpacing(10);

        escenaSalirDeMenu = new Scene(vbox3, 640, 640);
        return escenaSalirDeMenu;
    }

    private Scene crearEscenaSalirDeJuego() {
        Label label = new Label("Desea ir al Menu?");

        Button botonNo = new Button("NO");
        botonNo.setOnAction(e -> cambiarEscenas(escenaJuego));
        Button botonSi = new Button("SI");
        botonSi.setOnAction(e -> cambiarEscenas(escenaMenu));
        VBox vbox8 = new VBox(label, botonNo, botonSi);
        vbox8.setAlignment(Pos.CENTER);

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