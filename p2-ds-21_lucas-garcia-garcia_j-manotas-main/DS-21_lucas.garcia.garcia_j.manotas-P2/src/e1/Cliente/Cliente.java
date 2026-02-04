package e1.Cliente;

import e1.Cuentas.CondicionCuenta;
import e1.Cuentas.Cuenta;
import e1.Cuentas.CuentaAhorro;
import e1.Cuentas.CuentaCorriente;

import java.util.ArrayList;

public abstract class Cliente {

    private final String dni;
    public String getDni() {
        return dni;
    }

    private final ArrayList<Cuenta> cuentas = new ArrayList<>();

    public Cliente(String dni) {
        this.dni = dni;
    }

    public Cuenta getCuenta(int index) {
        return cuentas.get(index);
    }

    public void agregarCuentaCorriente(String iban) {
        cuentas.add(new CuentaCorriente(iban));
    }

    protected void agregarCuentaAhorro(String iban, CondicionCuenta condiciones) {
        cuentas.add(new CuentaAhorro(iban, condiciones));
    }
    public abstract void agregarCuentaAhorro(String iban);
}