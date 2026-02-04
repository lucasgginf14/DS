package e1.Cliente;

import e1.Cuentas.CondicionCuenta;

public class ClienteVIP extends Cliente{

    public ClienteVIP(String dni) {
        super(dni);
    }

    @Override
    public void agregarCuentaAhorro(String iban) {
        agregarCuentaAhorro(iban, CondicionCuenta.VIP);
    }
}
