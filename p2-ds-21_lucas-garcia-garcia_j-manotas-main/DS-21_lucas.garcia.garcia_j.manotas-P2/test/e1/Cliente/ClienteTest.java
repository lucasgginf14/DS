package e1.Cliente;

import e1.Cuentas.Cuenta;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    static ClienteNormal normal;
    static ClientePreferente preferente;
    static ClienteVIP vip;

    @BeforeAll
    static void init() {
        normal = new ClienteNormal("58399537L");
        preferente = new ClientePreferente("68268480S");
        vip = new ClienteVIP("56719903D");
    }

    @Test
    void getDni() {
        assertEquals(normal.getDni(), "58399537L");
        assertEquals(preferente.getDni(), "68268480S");
        assertEquals(vip.getDni(), "56719903D");
    }

    @Test
    void funcion() {
        normal.agregarCuentaCorriente("cuentacorrientenormal");
        normal.agregarCuentaAhorro("cuentaahorronormal");
        preferente.agregarCuentaAhorro("cuentaahorropreferente");
        vip.agregarCuentaAhorro("cuentahorrovip");

        Cuenta cuenta = normal.getCuenta(0);
        assertEquals(cuenta.getIban(), "cuentacorrientenormal");

        Cuenta normalC = normal.getCuenta(1);
        Cuenta preferenteC = preferente.getCuenta(0);
        Cuenta vipC = vip.getCuenta(0);

        assertThrows(IllegalStateException.class, () -> normalC.retirarSaldo(1));

        preferenteC.retirarSaldo(999_99);
        assertThrows(IllegalStateException.class, () -> preferenteC.retirarSaldo(10));

        vipC.retirarSaldo(2_000_000_00L);
    }
}