package e1.Cuentas;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    static CuentaCorriente cuentaCorriente;
    static CuentaAhorro cuentaAhorro;

    @BeforeAll
    static void init() {
        cuentaCorriente = new CuentaCorriente("T10-U09-W09-P10-U18");
        cuentaAhorro = new CuentaAhorro("A14-L33-O42-N29");
    }

    @Test
    void ibanGetter() {
        assertEquals(cuentaCorriente.getIban(),"T10-U09-W09-P10-U18" );
        assertEquals(cuentaAhorro.getIban(), "A14-L33-O42-N29");
    }

    @Test
    void funcionamiento() {
        assertEquals(cuentaCorriente.getSaldo(), 0);
        assertEquals(cuentaAhorro.getSaldo(), 0);

        // Probamos a ingresar retirar dinero cuando aun no hay e ingresar / retirar dineros negativos
        assertThrows(IllegalStateException.class, () -> cuentaCorriente.retirarSaldo(1000000));
        assertThrows(IllegalStateException.class, () -> cuentaAhorro.retirarSaldo(1000000));

        assertThrows(IllegalArgumentException.class, () -> cuentaCorriente.retirarSaldo(-1000000));
        assertThrows(IllegalArgumentException.class, () -> cuentaAhorro.retirarSaldo(-1000000));

        assertThrows(IllegalArgumentException.class, () -> cuentaCorriente.ingresarSaldo(-100));
        assertThrows(IllegalArgumentException.class, () -> cuentaAhorro.ingresarSaldo(-100));

        // Comprobamos el funcionamiento
        cuentaCorriente.ingresarSaldo(900000);
        cuentaAhorro.ingresarSaldo(900000);

        assertEquals(cuentaCorriente.getSaldo(), 900000);
        assertEquals(cuentaAhorro.getSaldo(), 900000);

        cuentaCorriente.retirarSaldo(450000);
        cuentaAhorro.retirarSaldo(450000);

        assertEquals(cuentaCorriente.getSaldo(), 450000);

        long intereses = 450000 / 100 * cuentaAhorro.condiciones.getComision();
        assertEquals(cuentaAhorro.getSaldo(), 450000 - intereses);
    }

    @Test
    void testHashCode() {
        assertEquals(cuentaCorriente.hashCode(), cuentaCorriente.getIban().hashCode());
        assertEquals(cuentaAhorro.hashCode(), cuentaAhorro.getIban().hashCode());
    }
}