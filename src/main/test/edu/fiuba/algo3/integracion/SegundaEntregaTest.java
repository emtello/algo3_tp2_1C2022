package edu.fiuba.algo3.integracion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.calle.Calle;
import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.direccion.Derecha;
import edu.fiuba.algo3.modelo.direccion.Direccion;
import edu.fiuba.algo3.modelo.direccion.Izquierda;
import edu.fiuba.algo3.modelo.modificador.CambioDeVehiculo;
import edu.fiuba.algo3.modelo.modificador.Desfavorable;
import edu.fiuba.algo3.modelo.modificador.Favorable;
import edu.fiuba.algo3.modelo.modificador.Modificador;
import edu.fiuba.algo3.modelo.modificador.Pozo;
import edu.fiuba.algo3.modelo.tablero.Tablero;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.Camioneta4x4;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;
import edu.fiuba.algo3.modelo.vehiculos.Moto;

public class SegundaEntregaTest {
    Tablero tablero = new Tablero(10, 10);
    Vehiculo moto = new Moto(this.tablero);
    Celda celdaInicial = new Celda(0, 0);
    Celda celdaFinal = new Celda(0, 1);
    Direccion direccion = new Derecha();

    public void iniciarConfig(Vehiculo vehiculo, Modificador modificador) {    
        this.tablero.agregarvehiculo(vehiculo);
        this.tablero.iniciarEn(celdaInicial);
        
        Calle calle = new Calle(this.celdaInicial, this.celdaFinal, modificador);

        this.tablero.agregarModificador(this.celdaInicial, this.celdaFinal, modificador);
        
        this.celdaInicial.agregarCalle(calle);
        this.celdaFinal.agregarCalle(calle);
    }

    @Test
    public void unVehiculoEncuentraUnaSorpresaDesfavorableYElTotalDeMovimientosEsConComaDebeRedondear() {
        Vehiculo vehiculo = new Moto(this.tablero);
        Modificador modificador = new Desfavorable();

        this.iniciarConfig(vehiculo, modificador);

        vehiculo.sumarMovimientos(4);
        vehiculo.mover(this.direccion);

        long cantidadMovimientosEsperados = 6;

        assertEquals(cantidadMovimientosEsperados, vehiculo.movimientos());
    }

    @Test
    public void unAutoAtraviesaLaCiudadYEncuentraUnaSorpresaFavorableResta20PorcientoDeMovimientos() {
        Vehiculo auto = new Auto(this.tablero);
        Modificador pozo = new Pozo();

        this.iniciarConfig(auto, pozo);

        Celda celda02 = new Celda(0, 2);
        Modificador favorable = new Favorable();

        // Calle calle0102 = new Calle(this.celdaFinal, celda02, favorable);
        // this.celdaFinal.agregarCalle(calle0102);
        // celda02.agregarCalle(calle0102);

        this.tablero.agregarModificador(this.celdaFinal, celda02, favorable);

        long cantMovimientosFinalEsperado = 4;
        
        this.tablero.mover(this.direccion);
        this.tablero.mover(this.direccion);
        
        assertEquals(cantMovimientosFinalEsperado, auto.movimientos());
    }

    @Test
    public void unaMotoAtraviesaLaCiudadYEncuentraUnaSorpresaFavorableResta20PorcientoDeMoviemientos() {
        Vehiculo moto = new Moto(this.tablero);
        Modificador pozo = new Pozo();

        this.iniciarConfig(moto, pozo);

        Celda celda02 = new Celda(0, 2);
        Modificador favorable = new Favorable();

        // Calle calle0102 = new Calle(this.celdaFinal, celda02, favorable);
        // this.celdaFinal.agregarCalle(calle0102);
        // celda02.agregarCalle(calle0102);

        this.tablero.agregarModificador(this.celdaFinal, celda02, favorable);

        long cantMovimientosFinalEsperado = 4;
        
        this.tablero.mover(this.direccion);
        this.tablero.mover(this.direccion);
        
        assertEquals(cantMovimientosFinalEsperado, moto.movimientos());
    }

    @Test
    public void una4x4AtraviesaLaCiudadYEncuentraUnaSorpresaFavorableResta20PorcientoDeMoviemientos() {
        Vehiculo camioneta4x4 = new Camioneta4x4(this.tablero);
        Modificador pozo = new Pozo();

        this.iniciarConfig(camioneta4x4, pozo);

        Celda celda02 = new Celda(0, 2);
        Modificador favorable = new Favorable();

        // Calle calle0102 = new Calle(this.celdaFinal, celda02, favorable);
        // this.celdaFinal.agregarCalle(calle0102);
        // celda02.agregarCalle(calle0102);

        this.tablero.agregarModificador(this.celdaFinal, celda02, favorable);

        Direccion izquierda = new Izquierda();

        long cantMovimientosFinalEsperado = 3;
        
        this.tablero.mover(this.direccion);
        this.tablero.mover(izquierda);
        this.tablero.mover(this.direccion);
        this.tablero.mover(this.direccion);
    
        assertEquals(cantMovimientosFinalEsperado, camioneta4x4.movimientos());
    }

    @Test
    public void unAutoAtraviesaLaCiudadYEncuentraUnaSorpresaDesfavorableSuma20PorcientoDeMovimientos() {
        Vehiculo auto = new Auto(this.tablero);
        Modificador pozo = new Pozo();

        this.iniciarConfig(auto, pozo);

        Celda celda02 = new Celda(0, 2);
        Modificador desfavorable = new Desfavorable();

        // Calle calle0102 = new Calle(this.celdaFinal, celda02, desfavorable);
        // this.celdaFinal.agregarCalle(calle0102);
        // celda02.agregarCalle(calle0102);

        this.tablero.agregarModificador(this.celdaFinal, celda02, desfavorable);

        long cantMovimientosFinalEsperado = 6;

        this.tablero.mover(this.direccion);
        this.tablero.mover(this.direccion);

        assertEquals(cantMovimientosFinalEsperado, auto.movimientos());
    }

    @Test
    public void unaMotoAtraviesaLaCiudadYEncuentraUnaSorpresaDesfavorableSuma25PorcientoDeMovimientos() {
        Vehiculo moto = new Moto(this.tablero);
        Modificador pozo = new Pozo();

        this.iniciarConfig(moto, pozo);

        Celda celda02 = new Celda(0, 2);
        Modificador desfavorable = new Desfavorable();

        // Calle calle0102 = new Calle(this.celdaFinal, celda02, desfavorable);
        // this.celdaFinal.agregarCalle(calle0102);
        // celda02.agregarCalle(calle0102);

        this.tablero.agregarModificador(this.celdaFinal, celda02, desfavorable);


        long cantMovimientosFinalEsperado = 6;

        this.tablero.mover(this.direccion);
        this.tablero.mover(this.direccion);

        assertEquals(cantMovimientosFinalEsperado, moto.movimientos());
    }

    @Test
    public void una4x4AtraviesaLaCiudadYEncuentraUnaSorpresaDesfavorableSuma20PorcientoDeMovimientos() {
        Vehiculo camioneta4x4 = new Camioneta4x4(this.tablero);
        Modificador pozo = new Pozo();

        this.iniciarConfig(camioneta4x4, pozo);
        
        Celda celda02 = new Celda(0, 2);
        Modificador desfavorable = new Desfavorable();

        // Calle calle0102 = new Calle(this.celdaFinal, celda02, desfavorable);
        // this.celdaFinal.agregarCalle(calle0102);
        // celda02.agregarCalle(calle0102);
        this.tablero.agregarModificador(this.celdaFinal, celda02, desfavorable);

        Direccion izquierda = new Izquierda();

        long cantMovimientosFinalEsperado = 5;
        
        this.tablero.mover(this.direccion);
        this.tablero.mover(izquierda);
        this.tablero.mover(this.direccion);
        this.tablero.mover(this.direccion);

        assertEquals(cantMovimientosFinalEsperado, camioneta4x4.movimientos());
    }

    @Test
    public void unVehiculoEncuentraUnaSorpresaFavorableEnElPrimerMovimientoLosMovimientosTotalesSon1() {
        Vehiculo vehiculo = new Moto(this.tablero);
        Modificador modificador = new Favorable();

        this.iniciarConfig(vehiculo, modificador);

        vehiculo.mover(direccion);

        long cantMovimientosEsperados = 1;

        assertEquals(cantMovimientosEsperados, vehiculo.movimientos());
    }

    @Test
    public void unVehiculoEncuentraUnaSorpresaFavorableYElTotalDeMovimientosEsConComaDebeRedondear() {
        Vehiculo vehiculo = new Moto(this.tablero);
        Modificador modificador = new Favorable();

        this.iniciarConfig(vehiculo, modificador);

        vehiculo.sumarMovimientos(3);
        vehiculo.mover(this.direccion);

        long cantidadMovimientosEsperados = 3;

        assertEquals(cantidadMovimientosEsperados, vehiculo.movimientos());
    }
    
    @Test
    public void unAutoAtraviesaLaCiudadYSeEncuentraConUnCambioDeVehiculoYCambiaPor4X4() {
        Vehiculo auto = new Auto(this.tablero);
        Modificador cambio = new CambioDeVehiculo();

        this.iniciarConfig(auto, cambio);

        this.tablero.mover(this.direccion);

        assertEquals(Camioneta4x4.class, this.tablero.getVehiculo().getClass());
    }

    @Test
    public void unaMotoAtraviesaLaCiudadYSeEncuentraConUnCambioDeVehiculoYCambiaPorAuto() {
        Vehiculo auto = new Moto(this.tablero);
        Modificador cambio = new CambioDeVehiculo();

        this.iniciarConfig(auto, cambio);

        this.tablero.mover(this.direccion);

        assertEquals(Auto.class, this.tablero.getVehiculo().getClass());
    }

    @Test
    public void una4X4AtraviesaLaCiudadYSeEncuentraConUnCambioDeVehiculoYCambiaPorMoto() {
        Vehiculo Camioneta4x4 = new Camioneta4x4(this.tablero);
        Modificador cambio = new CambioDeVehiculo();

        this.iniciarConfig(Camioneta4x4, cambio);

        this.tablero.mover(this.direccion);

        assertEquals(Moto.class, this.tablero.getVehiculo().getClass());
    }

}
