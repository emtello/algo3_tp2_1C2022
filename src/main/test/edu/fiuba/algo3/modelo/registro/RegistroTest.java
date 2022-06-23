package edu.fiuba.algo3.modelo.registro;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RegistroTest {


    @Test
    public void cargarDosPuntajesYQueLosOrdene() {
        Registro registro = new Registro();

        Puntaje puntajeMuchosMovimientos = new Puntaje("segudoUsuario", 15); 
        Puntaje puntajePocosMovimientos = new Puntaje("primerUsuario", 10); 

        registro.cargarPuntaje(puntajeMuchosMovimientos);
        registro.cargarPuntaje(puntajePocosMovimientos);

        registro.ordenarMayorAMenor();

        assertEquals(puntajePocosMovimientos, registro.obtenerPuntaje(0));
        assertEquals(puntajeMuchosMovimientos, registro.obtenerPuntaje(1));
    }

    @Test
    public void cargarDosPuntajesIgualesOrdenaLaListaDeFormaQueSeRegistro() {
        Registro registro = new Registro();

        Puntaje primerPuntaje = new Puntaje("primerUsuario", 10); 
        Puntaje segundoPuntaje = new Puntaje("segudoUsuario", 10); 
        Puntaje tercerPuntaje = new Puntaje("tercerUsuario",8);

        registro.cargarPuntaje(primerPuntaje);
        registro.cargarPuntaje(segundoPuntaje);
        registro.cargarPuntaje(tercerPuntaje);

        registro.ordenarMayorAMenor();

        assertEquals(tercerPuntaje, registro.obtenerPuntaje(0));
        assertEquals(primerPuntaje, registro.obtenerPuntaje(1));
        assertEquals(segundoPuntaje, registro.obtenerPuntaje(2));
    }


}