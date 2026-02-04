package e1.Cuentas;

public enum CondicionCuenta {

    NORMAL           (0, 1000, 4, 300),
    PREFERENTE(-1000_00,  500, 2, 100),
    VIP (Long.MIN_VALUE,    0, 0, 0);

    private final long minSaldo;
    public long getMinSaldo(){
        return minSaldo;
    }

    private final float minIngreso;
    public float getMinIngreso(){
        return minIngreso;
    }

    private final long comision;
    public long getComision() {
        return comision;
    }

    private final long minComision;
    public long getMinComision(){
        return minComision;
    }

    CondicionCuenta(long minSaldo, float minIngreso, long comision, long minComision){
        this.minSaldo = minSaldo;
        this.minIngreso = minIngreso;
        this.comision = comision;
        this.minComision = minComision;
    }
}