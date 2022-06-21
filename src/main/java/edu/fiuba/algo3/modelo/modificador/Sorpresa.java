package edu.fiuba.algo3.modelo.modificador;

public interface Sorpresa {

    public static final Double COEFICIENTE_FAVORABLE = 0.8;
    public static final Double COEFICIENTE_DESFAVORABLE = 1.25;

    long aplicarSorpresa(long movimientos);

}
