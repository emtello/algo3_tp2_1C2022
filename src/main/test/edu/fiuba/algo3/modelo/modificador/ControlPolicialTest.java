package edu.fiuba.algo3.modelo.modificador;

import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.direccion.Direccion;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.Camioneta4x4;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;
import org.junit.jupiter.api.Test;


import static org.mockito.Mockito.*;


public class ControlPolicialTest extends ModificadorTest {

    @Test
    public void modificadorControlSeCruzaConMotoEInvocaMetodoDeMotoCorrespondiente() {

        ControlPolicial controlPolicial = new ControlPolicial();

        Vehiculo motoMock = mock(Moto.class);

        doAnswer(invocation -> {
            motoMock.sumarMovimientos(3);
            return null;
        }).when(motoMock).aplicarModificador(isA(ControlPolicial.class));

        controlPolicial.cruzarCon(motoMock);

        // Verify para validar que motoMock.aplicarModificador() fue llamado
        verify(motoMock).sumarMovimientos(3);
    }

    @Test
    public void modificadorControlSeCruzaConAutoEInvocaMetodoDeAutoCorrespondiente() {

        ControlPolicial controlPolicial = new ControlPolicial();

        Vehiculo autoMock = mock(Auto.class);

        doAnswer(invocation -> {
            autoMock.sumarMovimientos(3);
            return null;
        }).when(autoMock).aplicarModificador(isA(ControlPolicial.class));

        controlPolicial.cruzarCon(autoMock);

        // Verify para validar que motoMock.aplicarModificador() fue llamado
        verify(autoMock).sumarMovimientos(3);
    }

    @Test
    public void modificadorControlSeCruzaConCamionetaEInvocaMetodoDeCamionetaCorrespondiente() {

        ControlPolicial controlPolicial = new ControlPolicial();

        Vehiculo camionetaMock = mock(Camioneta4x4.class);

        doAnswer(invocation -> {
            camionetaMock.sumarMovimientos(3);
            return null;
        }).when(camionetaMock).aplicarModificador(isA(ControlPolicial.class));

        controlPolicial.cruzarCon(camionetaMock);

        // Verify para validar que motoMock.aplicarModificador() fue llamado
        verify(camionetaMock).sumarMovimientos(3);
    }
}