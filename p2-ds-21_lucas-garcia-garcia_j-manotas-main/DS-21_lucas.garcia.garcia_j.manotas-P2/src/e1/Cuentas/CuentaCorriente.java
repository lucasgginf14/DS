package e1.Cuentas;

public class CuentaCorriente extends Cuenta {

    public CuentaCorriente(String iban){
        super(iban);
    }

    @Override
    public void ingresarSaldo(long centimos){
        if (centimos < 0)
            throw new IllegalArgumentException("No se puede ingresar dinero negativo");
        saldo += centimos;
    }

    @Override
    public void retirarSaldo(long centimos) {
        if (centimos < 0)
            throw new IllegalArgumentException("No se puede retirar dinero negativo");
        if (saldo - centimos < 0)
            throw new IllegalStateException("No se puede retirar mas dinero del que hay");
        saldo -= centimos;
    }
}