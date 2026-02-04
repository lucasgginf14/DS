package e1.Cliente;

import e1.Cuentas.CondicionCuenta;

public class ClienteNormal extends  Cliente {

    public ClienteNormal(String dni) {
        super(dni);
    }

    @Override
    public void agregarCuentaAhorro(String iban) {
        agregarCuentaAhorro(iban, CondicionCuenta.NORMAL);
    }
}