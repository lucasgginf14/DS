package e1.Cuentas;

public abstract class Cuenta {

    private final String iban;
    public String getIban() {
        return iban;
    }

    protected long saldo;
    public long getSaldo(){
        return saldo;
    }

    public Cuenta(String iban){
        this.iban = iban;
        saldo = 0;
    }

    public abstract void ingresarSaldo(long centimos) throws IllegalArgumentException;
    public abstract void retirarSaldo(long centimos) throws IllegalArgumentException, IllegalStateException;

    @Override
    public boolean equals(Object obj){
        if(obj == null) return false;
        if(!(obj instanceof Cuenta)) return false;
        return iban.equals(((Cuenta)obj).iban);
    }

    @Override
    public int hashCode(){
        return iban.hashCode();
    }
}