package e1.Cliente;

import e1.Cuentas.CondicionCuenta;

public class ClientePreferente extends Cliente {

    public ClientePreferente(String dni) {
        super(dni);
    }

    @Override
    public void agregarCuentaAhorro(String iban) {
        agregarCuentaAhorro(iban, CondicionCuenta.PREFERENTE);
    }
}