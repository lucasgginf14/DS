package e1.Cuentas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CondicionCuentaTest {

    @Test
    void getMinSaldo() {
        assertEquals(CondicionCuenta.NORMAL.getMinSaldo(), 0);
        assertEquals(CondicionCuenta.PREFERENTE.getMinSaldo(), -1000_00);
        assertEquals(CondicionCuenta.VIP.getMinSaldo(), Long.MIN_VALUE);
    }

    @Test
    void getMinIngreso() {
        assertEquals(CondicionCuenta.NORMAL.getMinIngreso(), 1000);
        assertEquals(CondicionCuenta.PREFERENTE.getMinIngreso(), 500);
        assertEquals(CondicionCuenta.VIP.getMinIngreso(), 0);
    }

    @Test
    void getComision() {
        assertEquals(CondicionCuenta.NORMAL.getComision(), 4);
        assertEquals(CondicionCuenta.PREFERENTE.getComision(), 2);
        assertEquals(CondicionCuenta.VIP.getComision(), 0);
    }

    @Test
    void getMinComision() {
        assertEquals(CondicionCuenta.NORMAL.getMinComision(), 300);
        assertEquals(CondicionCuenta.PREFERENTE.getMinComision(), 100);
        assertEquals(CondicionCuenta.VIP.getMinComision(), 0);
    }
}