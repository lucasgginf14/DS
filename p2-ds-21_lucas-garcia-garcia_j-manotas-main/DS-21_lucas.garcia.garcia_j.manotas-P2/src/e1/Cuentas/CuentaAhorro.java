package e1.Cuentas;

public class CuentaAhorro extends Cuenta{

    CondicionCuenta condiciones;

    public CuentaAhorro(String iban){
        super(iban);
        condiciones = CondicionCuenta.NORMAL;
    }

    public CuentaAhorro(String iban, CondicionCuenta condiciones) {
        super(iban);
        this.condiciones = condiciones;
    }

    @Override
    public void ingresarSaldo(long centimos) {
        if (centimos < 0)
            throw new IllegalArgumentException("No se puede ingresar dinero negativo");
        if (centimos < condiciones.getMinIngreso())
            throw new IllegalArgumentException("El ingreso para esta cuenta debe ser mayor que " + condiciones.getMinSaldo());
        saldo += centimos;
    }

    @Override
    public void retirarSaldo(long centimos) {
        if (centimos < 0)
            throw new IllegalArgumentException("No se puede retirar dinero negativo");
        if (saldo - centimos < condiciones.getMinSaldo())
            throw new IllegalStateException("No se puede retirar esa cantidad con las condiciones presentes");

        long comision = Math.max((condiciones.getComision() * centimos) / 100, condiciones.getMinComision());
        saldo -= centimos + comision;
    }
}